package isg.pfe.travelAgency.Services;


import isg.pfe.travelAgency.Entities.Vehicle;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VehicleServices {
    ResponseEntity<?> SaveVehicle(Vehicle vehicle);
    ResponseEntity<List<Vehicle>> ListVehicle();
    ResponseEntity DeleteVehicle(Long id);
    ResponseEntity FindVehicle(Long id);
    ResponseEntity UpdateVehicle(Long id,Vehicle newVehicle);
}
