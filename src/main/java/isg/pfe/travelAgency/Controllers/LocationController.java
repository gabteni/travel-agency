package isg.pfe.travelAgency.Controllers;

import isg.pfe.travelAgency.Entities.Location;
import isg.pfe.travelAgency.Services.LocationServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/Locations")

public class LocationController {
    private final Logger Log = LoggerFactory.getLogger(Location.class);
    @Autowired
    LocationServices locationServices;
    @GetMapping("/all")
    public ResponseEntity<List<Location>>getAllLocations(){
        return locationServices.ListLocations();
    }
    @PutMapping("/Update/{id}")
    public  ResponseEntity updateLocation(@PathVariable Integer id,@RequestBody Location location){
        return locationServices.UpdateLocation(id,location);
    }
    @PostMapping("Optimize")
    public ResponseEntity<List<Location>>Optimize(@RequestBody List<Location> locations){
        return locationServices.Optimize(locations);
    }

    @PostMapping("/New")
    public  ResponseEntity<?> addLocation(@RequestBody Location location){
        return locationServices.SaveLocation(location);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteLocation(@PathVariable Integer id){
        return locationServices.DeleteLocation(id);
    }
    @GetMapping(value = "/find/{id}")
    public  ResponseEntity findLocation(@PathVariable ("id")Integer id){
        Log.info("Request for finding location {}",id);
        return locationServices.FindLocation(id);
    }
}
