package isg.pfe.travelAgency.Controllers;

import isg.pfe.travelAgency.Entities.Vehicle;
import isg.pfe.travelAgency.Entities.VehicleModel;
import isg.pfe.travelAgency.Services.VehicleModelServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/VehicleModels")
public class VehicleModelController {
    private final Logger Log = LoggerFactory.getLogger(VehicleModel.class);
    @Autowired
    VehicleModelServices vehicleModelServices;
    @GetMapping("/all")
    public ResponseEntity<List<VehicleModel>> getAllVehicleModels(){
        return vehicleModelServices.ListVehicleModel();
    }
    @PutMapping("/Update/{id}")
    public  ResponseEntity updateVehicleModel(@PathVariable Long id,@RequestBody VehicleModel vehicleModel){
        return vehicleModelServices.UpdateVehicleModel(id,vehicleModel);
    }
    @PostMapping("/New")
    public  ResponseEntity<?> addVehicleModel(@RequestBody VehicleModel vehicleModel){
        return vehicleModelServices.SaveVehicleModel(vehicleModel);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteVehicleModel(@PathVariable Long id){
        return vehicleModelServices.DeleteVehicleModel(id);
    }
    @GetMapping(value = "/find/{id}")
    public  ResponseEntity findVehicleModel(@PathVariable ("id")long id){
        Log.info("Request for finding vehicle model {}",id);
        return vehicleModelServices.FindVehicleModel(id);}

}
