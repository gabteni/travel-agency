/*package isg.pfe.travelAgency.Controllers;

import isg.pfe.travelAgency.Entities.MyUserDetails;
import isg.pfe.travelAgency.Entities.UserDetailsImp;
import isg.pfe.travelAgency.Entities.UserU;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
public class UserController {
    @RequestMapping("/login")
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
    }
}*/
