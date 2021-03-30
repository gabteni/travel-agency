package isg.pfe.travelAgency.Controllers;

import isg.pfe.travelAgency.Entities.Location;
import isg.pfe.travelAgency.Entities.MyUserDetails;
import isg.pfe.travelAgency.Entities.UserDetailsImp;
import isg.pfe.travelAgency.Entities.UserU;
import isg.pfe.travelAgency.Services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/User")
public class UserController {
    private final Logger Log = LoggerFactory.getLogger(UserU.class);
    @Autowired
    UserServices userServices;
    @PutMapping("/Update/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody UserU user){
        return userServices.UpdateUser(id,user);
    }
    @PostMapping("/New")
    public  ResponseEntity<?> addUser(@RequestBody UserU user){
        return userServices.SaveUser(user);

    }

    @GetMapping(value = "/find/{id}")
    public  ResponseEntity findUser(@PathVariable ("id")long id){
        Log.info("Request for finding location {}",id);
        return userServices.FindUser(id);
    }

    /*@RequestMapping("/login")
    public boolean login(@RequestBody UserU user) {
       // UserDetails userDetails=new UserDetailsImp().loadUserByUsername(user.getUserName());
       //new UserDetailsService().
        //return userDetails.getAuthorities()!=null;
        return user.getUserName().equals("test") && user.getPassword().equals("test");
    }

    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder().decode(authToken)).split(":")[0];
    }*/

}
