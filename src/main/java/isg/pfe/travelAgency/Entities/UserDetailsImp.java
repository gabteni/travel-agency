package isg.pfe.travelAgency.Entities;


import isg.pfe.travelAgency.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsImp implements UserDetailsService {
    @Autowired
    private     UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserU user =userRepository.findByUserName(userName);
        if (user==null)
            throw new UsernameNotFoundException("user not found ");
        return new MyUserDetails(user);
    }
}
