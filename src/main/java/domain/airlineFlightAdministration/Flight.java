package domain.airlineFlightAdministration;

import domain.employeeFlightAdministration.Locations;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Flight() {
    }

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "destination_time")
    private LocalDateTime destinationTime;

    @ElementCollection
    @MapKeyColumn(name = "TravelClass")
    @MapKeyEnumerated(EnumType.STRING)
    @CollectionTable(name = "pricing_travelclass")
    Map<TravelClass, PricingInformation> pricingByTravelClass = new HashMap<>();

    @OneToOne
    private Locations locations;

    @Transient
    private Duration durationFlight = Duration.between(destinationTime, departureTime);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(LocalDateTime destinationTime) {
        this.destinationTime = destinationTime;
    }

    public Map<TravelClass, PricingInformation> getPricingByTravelClass() {
        return pricingByTravelClass;
    }

    public void setPricingByTravelClass(Map<TravelClass, PricingInformation> pricingByTravelClass) {
        this.pricingByTravelClass = pricingByTravelClass;
    }

    public Duration getDurationFlight() {
        return durationFlight;
    }

    public void setDurationFlight(Duration durationFlight) {
        this.durationFlight = durationFlight;
    }

    public Locations getLocations() {
        return locations;
    }
}
