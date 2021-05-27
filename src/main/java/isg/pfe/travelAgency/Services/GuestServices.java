package isg.pfe.travelAgency.Services;

import isg.pfe.travelAgency.Entities.Guest;
import isg.pfe.travelAgency.Entities.Location;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GuestServices {


    ResponseEntity<?> SaveGuest(Guest guest);
    ResponseEntity<List<Guest>> ListGuests();
    ResponseEntity DeleteGuest(Integer id);
    ResponseEntity UpdateGuest(Integer id, Guest newGuest);
    ResponseEntity FindGuest(Integer id);
}
