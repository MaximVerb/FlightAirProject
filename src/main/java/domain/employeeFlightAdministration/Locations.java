package domain.employeeFlightAdministration;

import javax.persistence.*;

@Entity
public class Locations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_name")
    private String country;

    @Column(name = "city_name")
    private String city;

    @Column(name = "airport_name")
    private String airport;

    private String airportCode;

    @Enumerated(EnumType.STRING)
    private Direction direction;

    @Enumerated(EnumType.STRING)
    private Region region;

    enum Direction {
        DEPARTURE,DESTINATION;
    }

    enum Region {
        EU("Europe"), NA("North-America"),SA("South-America"),CA("Central-America"),
        AA("Antartica"),AS("Asia"), AF("Africa"),AUSI("Australia");

        Region(String region) {
        }
    }

    public Locations() {

    }

    public Locations(String country, String city, String airport, Direction direction, String airportCode, Region region) {
        this.country = country;
        this.city = city;
        this.airport = airport;
        this.direction = direction;
        this.airportCode = airportCode;
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
