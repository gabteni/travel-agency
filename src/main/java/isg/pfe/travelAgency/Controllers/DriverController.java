package isg.pfe.travelAgency.Controllers;

import isg.pfe.travelAgency.Entities.Driver;
import isg.pfe.travelAgency.Entities.Guest;
import isg.pfe.travelAgency.Services.DriverServices;
import isg.pfe.travelAgency.Services.GuestServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/Drivers")
public class DriverController {
    private final Logger Log = LoggerFactory.getLogger(Driver.class);
    @Autowired
    DriverServices driverServices;
    @GetMapping("/all")
    public ResponseEntity<List<Driver>> getAll(){
        return driverServices.ListDrivers();
    }
    @PutMapping("/Update/{id}")
    public  ResponseEntity update(@PathVariable Integer id,@RequestBody Driver driver){
        return driverServices.UpdateDriver(id,driver);
    }
    @PostMapping("/New")
    public  ResponseEntity<?> add(@RequestBody Driver driver){
        return driverServices.SaveDriver(driver);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        return driverServices.DeleteDriver(id);
    }
    @GetMapping(value = "/find/{id}")
    public  ResponseEntity find(@PathVariable ("id")Integer id){
        Log.info("Request for finding Driver {}",id);
        return driverServices.FindDriver(id);
    }
}
