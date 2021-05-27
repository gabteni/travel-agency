package isg.pfe.travelAgency.Services;

import isg.pfe.travelAgency.Entities.Location;
import isg.pfe.travelAgency.Entities.Trip;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TripServices {
    ResponseEntity<?> SaveTrip(Trip trip);
    ResponseEntity<List<Trip>> ListTrip();
    ResponseEntity DeleteTrip(Integer id);
    ResponseEntity UpdateTrip(Integer id, Trip newTrip);
    ResponseEntity FindTrip(Integer id);
    ResponseEntity <List<Trip>>FindTripByDriver(String id);
}
