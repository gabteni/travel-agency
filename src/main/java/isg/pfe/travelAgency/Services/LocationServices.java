package isg.pfe.travelAgency.Services;

import isg.pfe.travelAgency.Entities.Location;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LocationServices {
    ResponseEntity<?> SaveLocation(Location location);
    ResponseEntity<List<Location>> ListLocations();
    ResponseEntity DeleteLocation(Long id);
    ResponseEntity UpdateLocation(Long id,Location newLocation);
    ResponseEntity FindLocation(Long id);
    ResponseEntity Optimize(List<Location> locations);
}
