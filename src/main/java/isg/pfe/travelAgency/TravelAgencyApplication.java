package isg.pfe.travelAgency;

import isg.pfe.travelAgency.Entities.*;
import isg.pfe.travelAgency.Repositories.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.SunHints;

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
		/*@Bean
		ApplicationRunner initUsers(UserRepository plRepos)
		{	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			plRepos.deleteAll();
			if(!plRepos.findByUserName("test").isPresent()){
			return x ->{
				Stream.of(
						new UserU("test", encoder.encode("2671999test")),
						new UserU("test2", encoder.encode("2671999test2"))
				).forEach(plRepos::save);
			} ;}
			return null;
		}*/
	/*@Bean
	ApplicationRunner initLocations(LocationRepository plRepos)
	{

		return x ->{
			Stream.of(
					new Location(),new Location()
			).forEach(plRepos::save);
		} ;
	}@Bean
	ApplicationRunner initDrivers(DriverRepository plRepos)
	{

		return x ->{
			Stream.of(
					new Driver("sqd","sqds"),new Driver("eeza","dqsds")
			).forEach(plRepos::save);
		} ;
	}
	/*@Bean
	ApplicationRunner initlocation(TripRepository plRepos,LocationRepository LR ,DriverRepository Dr)
	{	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

		return x ->{
			Stream.of(
					new Trip(LR.findById(new Long(1)).get(),LR.findById(new Long(2)).get(),Dr.findById(new Long(1)).get())
			).forEach(plRepos::save);
		} ;
	}
	@Bean
	ApplicationRunner initGuests(GuestRepository plRepos)
	{

		return x ->{
			Stream.of(
					new Guest("Xd","ageGrp")
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
	}*/
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
