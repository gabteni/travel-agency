package isg.pfe.travelAgency;

import isg.pfe.travelAgency.Entities.Location;
import isg.pfe.travelAgency.Entities.UserU;
import isg.pfe.travelAgency.Repositories.LocationRepository;
import isg.pfe.travelAgency.Repositories.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Stream;

@SpringBootApplication
/*@RestController
@CrossOrigin(origins = "*")*/
public class TravelAgencyApplication {


	/*@GetMapping("/")
	public String login(){
		return "authenticated successfully" ;
	}*/


	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyApplication.class, args);
	}
	/*@Bean
	ApplicationRunner initPlayers(UserRepository plRepos)
	{	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

		return x ->{
			Stream.of(
					new UserU("test", encoder.encode("test")),
					new UserU("test2", encoder.encode("test2"))
			).forEach(plRepos::save);
		} ;
	}*/
	@Bean
	ApplicationRunner initLocations(LocationRepository plRepos)
	{	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

		return x ->{
			Stream.of(
					new Location(),
					new Location()
			).forEach(plRepos::save);
		} ;
	}
}
