package isg.pfe.travelAgency.Controllers;

import isg.pfe.travelAgency.Entities.Guest;

import isg.pfe.travelAgency.Services.GuestServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/Guests")
public class GuestController {
    private final Logger Log = LoggerFactory.getLogger(Guest.class);
     @Autowired
    GuestServices guestServices;
    @GetMapping("/all")
    public ResponseEntity<List<Guest>> getAll(){
        return guestServices.ListGuests();
    }
    @PutMapping("/Update/{id}")
    public  ResponseEntity update(@PathVariable Integer id,@RequestBody Guest guest){
        return guestServices.UpdateGuest(id,guest);
    }
    @PostMapping("/New")
    public  ResponseEntity<?> add(@RequestBody Guest guest){
        return guestServices.SaveGuest(guest);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        return guestServices.DeleteGuest(id);
    }
    @GetMapping(value = "/find/{id}")
    public  ResponseEntity find(@PathVariable ("id")Integer id){
        Log.info("Request for finding gust {}",id);
        return guestServices.FindGuest(id);
    }
}
