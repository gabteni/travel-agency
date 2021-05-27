package isg.pfe.travelAgency.Services;

import isg.pfe.travelAgency.Entities.Vehicle;
import isg.pfe.travelAgency.Entities.VehicleModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VehicleModelServices {
    ResponseEntity<?> SaveVehicleModel(VehicleModel vehicleModel);
    ResponseEntity<List<VehicleModel>> ListVehicleModel();
    ResponseEntity DeleteVehicleModel(Integer id);
    ResponseEntity UpdateVehicleModel(Integer id,VehicleModel newVehicleModel);
    ResponseEntity FindVehicleModel(Integer id);
}
