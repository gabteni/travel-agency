package isg.pfe.travelAgency.Services;

import isg.pfe.travelAgency.Entities.Vehicle;
import isg.pfe.travelAgency.Entities.VehicleModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VehicleModelServices {
    ResponseEntity<?> SaveVehicleModel(VehicleModel vehicleModel);
    ResponseEntity<List<VehicleModel>> ListVehicleModel();
    ResponseEntity DeleteVehicleModel(Long id);
    ResponseEntity UpdateVehicleModel(Long id,VehicleModel newVehicleModel);
    ResponseEntity FindVehicleModel(Long id);
}
