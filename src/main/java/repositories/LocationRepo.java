package repositories;

import domain.employeeFlightAdministration.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends JpaRepository<Locations,Long> {
}
