package isg.pfe.travelAgency.Controllers;


import isg.pfe.travelAgency.Entities.Trip;
import isg.pfe.travelAgency.Services.TripServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/Trips")
public class TripController {
    @Autowired
    TripServices tripServices;
    @GetMapping("/all")
    public ResponseEntity<List<Trip>> getAllTrips(){
        return tripServices.ListTrip();
    }
    @PutMapping("/Update/{id}")
    public  ResponseEntity updateTrip(@PathVariable Integer id,@RequestBody Trip trip){
        return tripServices.UpdateTrip(id,trip);
    }
    @PostMapping("/New")
    public  ResponseEntity<?> addTrip(@RequestBody Trip trip){
        return tripServices.SaveTrip(trip);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteTrip(@PathVariable Integer id){
        return tripServices.DeleteTrip(id);
    }
    @GetMapping(value = "/find/{id}")
    public  ResponseEntity findTrip(@PathVariable ("id")Integer id){

        return tripServices.FindTrip(id);
    }
    @GetMapping(value = "/find/driver/{id}")
    public  ResponseEntity findTripDriver(@PathVariable ("id")String id){

        return tripServices.FindTripByDriver(id);
    }
    @GetMapping(value = "/find/guide/{id}")
    public  ResponseEntity findTripGuide(@PathVariable ("id")String id){

        return tripServices.FindTripByGuide(id);
    }
}
