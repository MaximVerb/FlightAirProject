package repositories;

import domain.airlineFlightAdministration.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository <Flight,Long>, JpaSpecificationExecutor<Flight> {

    //named query voor prijzen , kan dan gebruikt worden door meerdere services

    //criteriabuilder voor algemene searchbox
}
