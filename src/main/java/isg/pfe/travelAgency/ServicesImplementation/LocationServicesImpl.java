package isg.pfe.travelAgency.ServicesImplementation;

import isg.pfe.travelAgency.Entities.Location;
import isg.pfe.travelAgency.Entities.Vehicle;
import isg.pfe.travelAgency.Repositories.LocationRepository;
import isg.pfe.travelAgency.Services.LocationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LocationServicesImpl implements LocationServices {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public ResponseEntity<?> SaveLocation(Location location) {
        return new ResponseEntity<>(locationRepository.save(location), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Location>> ListLocations() {
        List<Location>list=locationRepository.findAll();
        if (list.isEmpty())
        return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list,HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity DeleteLocation(Long id ) {
        Optional<Location> location = locationRepository.findById(id);
        if (!location.isPresent())
        return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   locationRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);}
    }

    @Override
    public ResponseEntity UpdateLocation(Long id, Location newLocation) {
        Optional<Location> location = locationRepository.findById(id);
        if (!location.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   newLocation.setId(id);
            Location location1=locationRepository.save(newLocation);
            return new ResponseEntity(location1,HttpStatus.ACCEPTED);}
    }

    @Override
    public ResponseEntity FindLocation(Long id) {
        Optional<Location> location=locationRepository.findById(id);
        if(!location.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(location.get(),HttpStatus.OK);
    }


}
