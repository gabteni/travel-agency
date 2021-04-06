package isg.pfe.travelAgency.Entities;


import isg.pfe.travelAgency.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsImp implements UserDetailsService {
    @Autowired
    private     UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserU> user =userRepository.findByUserName(userName);
        if (!user.isPresent())
            throw new UsernameNotFoundException("user not found ");
        return new MyUserDetails(user.get());
    }
}
