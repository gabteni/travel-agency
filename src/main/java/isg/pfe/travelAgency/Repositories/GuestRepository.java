package isg.pfe.travelAgency.Repositories;

import isg.pfe.travelAgency.Entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface GuestRepository extends JpaRepository<Guest,Long> {
}
