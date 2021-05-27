package isg.pfe.travelAgency.ServicesImplementation;

import isg.pfe.travelAgency.Entities.Location;
import isg.pfe.travelAgency.Entities.Vehicle;
import isg.pfe.travelAgency.Repositories.VehicleRepository;
import isg.pfe.travelAgency.Services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VehicleServicesImpl implements VehicleServices {
    @Autowired
    VehicleRepository vehicleRepository;
    @Override
    public ResponseEntity<?> SaveVehicle(Vehicle vehicle) {
        return new ResponseEntity<>(vehicleRepository.save(vehicle), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Vehicle>> ListVehicle() {
        List< Vehicle >list=vehicleRepository.findAll();
        if (list.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list,HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity DeleteVehicle(Integer id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (!vehicle.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   vehicleRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);}

    }

    @Override
    public ResponseEntity FindVehicle(Integer id) {
        Optional<Vehicle> vehicle=vehicleRepository.findById(id);
        if(!vehicle.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(vehicle.get(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity UpdateVehicle(Integer id, Vehicle newVehicle) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (!vehicle.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   newVehicle.setId(id);
            Vehicle vehicle1=vehicleRepository.save(newVehicle);
            return new ResponseEntity(vehicle1,HttpStatus.ACCEPTED);}
    }

}
