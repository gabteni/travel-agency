package isg.pfe.travelAgency.Repositories;

import isg.pfe.travelAgency.Entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DriverRepository extends JpaRepository<Driver,Integer> {
}
