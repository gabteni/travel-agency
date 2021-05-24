package isg.pfe.travelAgency.ServicesImplementation;

import isg.pfe.travelAgency.Entities.Trip;
import isg.pfe.travelAgency.Repositories.TripRepository;
import isg.pfe.travelAgency.Services.TripServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TripServicesImpl implements TripServices {

    @Autowired
    TripRepository tripRepository;

    @Override
    public ResponseEntity<?> SaveTrip(Trip trip) {
        return new ResponseEntity<>(tripRepository.save(trip), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Trip>> ListTrip() {
        List<Trip>list=tripRepository.findAll();
        if (list.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list,HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity DeleteTrip(Long id) {
        Optional<Trip> trip = tripRepository.findById(id);
        if (!trip.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   tripRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);}
    }

    @Override
    public ResponseEntity UpdateTrip(Long id, Trip newTrip) {
        Optional<Trip> trip = tripRepository.findById(id);
        if (!trip.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   newTrip.setId(id);
            Trip trip1=tripRepository.save(newTrip);
            return new ResponseEntity(trip1,HttpStatus.ACCEPTED);}
    }

    @Override
    public ResponseEntity FindTrip(Long id) {
        Optional<Trip> trip=tripRepository.findById(id);
        if(!trip.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(trip.get(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity <List<Trip>>FindTripByDriver(String id) {
        List<Trip>list=tripRepository.findByDriverUserName(id);
        if (list.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list,HttpStatus.OK) ;
    }
}
