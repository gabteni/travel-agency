package isg.pfe.travelAgency.Services;


import isg.pfe.travelAgency.Entities.Vehicle;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VehicleServices {
    ResponseEntity<?> SaveVehicle(Vehicle vehicle);
    ResponseEntity<List<Vehicle>> ListVehicle();
    ResponseEntity DeleteVehicle(Integer id);
    ResponseEntity FindVehicle(Integer id);
    ResponseEntity UpdateVehicle(Integer id,Vehicle newVehicle);
}
