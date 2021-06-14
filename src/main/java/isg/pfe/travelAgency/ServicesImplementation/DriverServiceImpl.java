package isg.pfe.travelAgency.ServicesImplementation;

import isg.pfe.travelAgency.Entities.Driver;
import isg.pfe.travelAgency.Entities.Guest;
import isg.pfe.travelAgency.Repositories.DriverRepository;
import isg.pfe.travelAgency.Services.DriverServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverServices {
    @Autowired
    DriverRepository driverRepository;
    @Override
    public ResponseEntity<?> SaveDriver(Driver driver) {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        driver.setPassword(encoder.encode(driver.getPassword()));
        return new ResponseEntity<>(driverRepository.save(driver), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Driver>> ListDrivers() {
        List<Driver>list=driverRepository.findAll();
        if (list.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list,HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity DeleteDriver(Integer id) {

        Optional<Driver> driver = driverRepository.findById(id);
        if (!driver.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   driverRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);}
    }

    @Override
    public ResponseEntity UpdateDriver(Integer id, Driver newDriver) {
        Optional<Driver> driver = driverRepository.findById(id);
        if (!driver.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   newDriver.setId(id);
            newDriver.setTrips(driver.get().getTrips());
            Driver driver1=driverRepository.save(newDriver);
            return new ResponseEntity(driver1,HttpStatus.ACCEPTED);}
    }

    @Override
    public ResponseEntity FindDriver(Integer id) {
        Optional<Driver> driver=driverRepository.findById(id);
        if(!driver.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(driver.get(),HttpStatus.OK);
    }
}
