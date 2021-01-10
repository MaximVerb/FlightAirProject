package services;

import domain.airlineFlightAdministration.Flight;
import domain.airlineFlightAdministration.PricingInformation;
import domain.airlineFlightAdministration.TravelClass;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface CalculatePriceService {
    List<Flight> getAllFlightsByCriteria(LocalDateTime time, String destination, TravelClass travelClass);
    List<PricingInformation> getAllPricingInformation
            (LocalDateTime time, String destination, TravelClass travelClass);


}
