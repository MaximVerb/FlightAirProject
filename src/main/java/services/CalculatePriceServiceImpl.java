package services;

import domain.airlineFlightAdministration.Flight;
import domain.airlineFlightAdministration.PricingInformation;
import domain.airlineFlightAdministration.TravelClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.FlightRepo;
import repositories.LocationRepo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Service
public class CalculatePriceServiceImpl implements CalculatePriceService {

    private FlightRepo flightRepo;

    private LocationRepo locationRepo;

    @Autowired
    public void setFlightRepo(FlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }

    @Autowired
    public void setLocationRepo(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    @Override
    //uiteindelijk niet gekozen voor criteriabuilder, want dat vereiste een path, wat een rechtstreekse property is van
//    een entiteit, er zal wel een manier zijn om via Locations naar destination te geen, via die path,
//    maar om het simpel te houden heb ik het hierbij gehouden
    public List<Flight> getAllFlightsByCriteria (LocalDateTime time, String destination, TravelClass travelClass) {
        Function<LocalDateTime, Predicate<Flight>> filterFlightsByTime =
                (LocalDateTime ldt) -> (Flight flight) -> flight.getDepartureTime().equals(ldt);

        Function<String, Predicate<Flight>> filterFlightsByDestination =
                (String dest) -> (Flight flight) -> flight.getLocations().getCountry().equals(dest);

        Function<TravelClass, Predicate<Flight>> filterFlightsByTravelClass =
                (TravelClass tc) -> (Flight flight) -> (flight.getPricingByTravelClass().get(tc).getAmountOfSeats())
                != 0 ;
        //alle travelclassen als keys zullen er altijd zijn, dus je moet controleren op beschikbaarheid

        return flightRepo.findAll()
                .stream()
                .filter(filterFlightsByDestination.apply(destination)
                .and(filterFlightsByTime.apply(time)
                .and(filterFlightsByTravelClass.apply(travelClass))))
                .collect(Collectors.toList());
    }

    @Override
    public List<PricingInformation> getAllPricingInformation
            (LocalDateTime time, String destination, TravelClass travelClass) {
        List<Flight> listOfFlights = getAllFlightsByCriteria(time,destination,travelClass);
        return listOfFlights.stream()
                .map(flight -> flight.getPricingByTravelClass().get(travelClass))
                .collect(Collectors.toList());
    }


}
