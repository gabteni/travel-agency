package isg.pfe.travelAgency.ServicesImplementation;

import isg.pfe.travelAgency.Entities.Location;
import isg.pfe.travelAgency.Entities.UserU;
import isg.pfe.travelAgency.Repositories.UserRepository;
import isg.pfe.travelAgency.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity<?> SaveUser(UserU user ) {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<List<UserU>> ListUsers() {
        return null;
    }

    @Override
    public ResponseEntity DeleteUser(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity UpdateUser(Integer id, UserU newUser) {
        Optional<UserU> userU = userRepository.findById(id);
        if (!userU.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   newUser.setId(id);
            BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
            newUser.setPassword(encoder.encode(newUser.getPassword()));
            UserU userU1=userRepository.save(newUser);
            return new ResponseEntity(userU1,HttpStatus.ACCEPTED);}
    }

    @Override
    public ResponseEntity FindUser(Integer id) {
        Optional<UserU> user=userRepository.findById(id);
        if(!user.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(user.get(),HttpStatus.OK);
    }
    @Override
    public ResponseEntity FindUserName(String name) {
       Optional<UserU> user =userRepository.findByUserName(name);
        if(!user.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(user.get(),HttpStatus.OK);
    }
}
