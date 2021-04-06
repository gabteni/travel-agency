package isg.pfe.travelAgency.Repositories;

import isg.pfe.travelAgency.Entities.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GuideRepository extends JpaRepository<Guide,Long> {
}
