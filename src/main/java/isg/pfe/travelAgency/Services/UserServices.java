package isg.pfe.travelAgency.Services;

import isg.pfe.travelAgency.Entities.Location;
import isg.pfe.travelAgency.Entities.UserU;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServices {

        ResponseEntity<?> SaveUser(UserU userU);
        ResponseEntity<List<UserU>> ListUsers();
        ResponseEntity DeleteUser(Long id);
        ResponseEntity UpdateUser(Long id,UserU newUser);
        ResponseEntity FindUser(Long id);

}
