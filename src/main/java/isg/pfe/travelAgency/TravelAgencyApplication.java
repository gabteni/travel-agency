package isg.pfe.travelAgency;

import isg.pfe.travelAgency.Entities.Location;
import isg.pfe.travelAgency.Entities.UserU;
import isg.pfe.travelAgency.Entities.Vehicle;
import isg.pfe.travelAgency.Entities.VehicleModel;
import isg.pfe.travelAgency.Repositories.LocationRepository;
import isg.pfe.travelAgency.Repositories.UserRepository;
import isg.pfe.travelAgency.Repositories.VehicleModelRepository;
import isg.pfe.travelAgency.Repositories.VehicleRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootApplication
@RestController//
@CrossOrigin(origins = "*")
public class TravelAgencyApplication {


	@GetMapping("/")
	public String login(){
		return "authenticated successfully" ;
	}


	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyApplication.class, args);
	}
	@Bean
	ApplicationRunner initPlayers(UserRepository plRepos)
	{	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

		return x ->{
			Stream.of(
					new UserU("test", encoder.encode("test")),
					new UserU("test2", encoder.encode("test2"))
			).forEach(plRepos::save);
		} ;
	}

	@Bean
	ApplicationRunner initLocations(LocationRepository plRepos)
	{

		return x ->{
			Stream.of(
					new Location()
			).forEach(plRepos::save);
		} ;
	}
	@Bean
	ApplicationRunner initMode(VehicleModelRepository plRepos)
	{

		return x ->{
			Stream.of(
					new VehicleModel()
			).forEach(plRepos::save);
		} ;
	}
	/*@Bean
	ApplicationRunner initVehic(VehicleRepository plRepos)
	{

		return x ->{
			Stream.of(
					new Vehicle()
			).forEach(plRepos::save);
		} ;
	}*/
	/*@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}*/

}
