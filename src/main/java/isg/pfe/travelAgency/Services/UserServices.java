package isg.pfe.travelAgency.Services;

import isg.pfe.travelAgency.Entities.Location;
import isg.pfe.travelAgency.Entities.UserU;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServices {

        ResponseEntity<?> SaveUser(UserU userU);
        ResponseEntity<List<UserU>> ListUsers();
        ResponseEntity DeleteUser(Integer id);
        ResponseEntity UpdateUser(Integer id,UserU newUser);
        ResponseEntity FindUser(Integer id);
        ResponseEntity FindUserName(String name);

}
