package isg.pfe.travelAgency.Repositories;

import isg.pfe.travelAgency.Entities.Driver;
import isg.pfe.travelAgency.Entities.Trip;
import isg.pfe.travelAgency.Entities.UserU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface TripRepository extends JpaRepository<Trip,Long> {
   // @Query("select t from Trip t where t.driver.id =?1")
    List<Trip> findByDriverUserName(String driverUserName);
}
