package isg.pfe.travelAgency.Repositories;

import isg.pfe.travelAgency.Entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LocationRepository extends JpaRepository<Location,Long> {
}
