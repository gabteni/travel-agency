package isg.pfe.travelAgency.Repositories;

import isg.pfe.travelAgency.Entities.UserU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface UserRepository extends JpaRepository <UserU,Long> {
  UserU findByUserName(String userName);

}
