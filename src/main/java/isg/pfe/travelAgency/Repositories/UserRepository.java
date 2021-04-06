package isg.pfe.travelAgency.Repositories;

import isg.pfe.travelAgency.Entities.UserU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface UserRepository extends JpaRepository <UserU,Long> {
  Optional<UserU> findByUserName(String userName);
  UserU findByUserNameAndPassword(String userName,String Password);
}
