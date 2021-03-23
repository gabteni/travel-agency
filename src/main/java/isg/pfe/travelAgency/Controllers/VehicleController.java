package isg.pfe.travelAgency.Controllers;

import isg.pfe.travelAgency.Entities.Vehicle;
import isg.pfe.travelAgency.Services.VehicleServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/Vehicles")
public class VehicleController {
    private final Logger Log = LoggerFactory.getLogger(Vehicle.class);
    @Autowired
    VehicleServices vehicleServices;
    @GetMapping("/all")
    public ResponseEntity<List<Vehicle>> getAllVehicles(){
        return vehicleServices.ListVehicle();
    }
    @PutMapping("/Update")
    public  ResponseEntity updateVehicle(@PathVariable Long id,@RequestBody Vehicle vehicle){
        return vehicleServices.UpdateVehicle(id,vehicle);
    }
    @PostMapping("/New")
    public  ResponseEntity<?> addVehicle(@RequestBody Vehicle vehicle){
        return vehicleServices.SaveVehicle(vehicle);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteVehicle(@PathVariable Long id){
        return vehicleServices.DeleteVehicle(id);
    }
    @GetMapping(value = "/find/{id}")
    public  ResponseEntity findVehicle(@PathVariable ("id")long id){
        Log.info("Request for finding vehicle    {}",id);
        return vehicleServices.FindVehicle(id);}
}
