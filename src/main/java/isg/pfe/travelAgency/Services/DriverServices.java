package isg.pfe.travelAgency.Services;

import isg.pfe.travelAgency.Entities.Driver;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DriverServices {
    ResponseEntity<?> SaveDriver(Driver driver);
    ResponseEntity<List<Driver>> ListDrivers();
    ResponseEntity DeleteDriver(Long id);
    ResponseEntity UpdateDriver(Long id, Driver newDriver);
    ResponseEntity FindDriver(Long id);
}
