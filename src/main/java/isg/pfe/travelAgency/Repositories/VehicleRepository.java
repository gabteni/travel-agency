package isg.pfe.travelAgency.Repositories;

import isg.pfe.travelAgency.Entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
