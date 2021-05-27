package isg.pfe.travelAgency.Repositories;

import isg.pfe.travelAgency.Entities.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VehicleModelRepository extends JpaRepository<VehicleModel,Integer> {
}
