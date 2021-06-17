package isg.pfe.travelAgency.ServicesImplementation;

import isg.pfe.travelAgency.Entities.Trip;
import isg.pfe.travelAgency.Repositories.GuestRepository;
import isg.pfe.travelAgency.Repositories.LocationRepository;
import isg.pfe.travelAgency.Repositories.TripRepository;
import isg.pfe.travelAgency.Services.GuestServices;
import isg.pfe.travelAgency.Services.TripServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TripServicesImpl implements TripServices {

    @Autowired
    TripRepository tripRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    GuestServices guestServices;
    @Autowired
    GuestRepository guestRepository;
    @Override
    public ResponseEntity<?> SaveTrip(Trip trip) {
        /*tripRepository.save(trip);
        Set<Location> route=new HashSet<Location>();
        for (Location location:trip.route) {
            System.out.println(location.getId()+"<--------------");
            Location l=locationRepository.findById(location.getId()).get();
            route.add(l);
            l.getTrips1().add(trip);
            locationRepository.saveAndFlush(l);

        }
        trip.setRoute(route);*/

        /*trip=tripRepository.save(trip);
        for(Guest g:trip.getGuests()){

            Guest gg=guestRepository.findById(g.getId()).get();
            gg.getTrips().add(trip);
            guestServices.SaveGuest(gg);

            
        }*/
        return new ResponseEntity<>( tripRepository.save(trip)  ,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Trip>> ListTrip() {
        List<Trip>list=tripRepository.findAll();
        if (list.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list,HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity DeleteTrip(Integer id) {
        Optional<Trip> trip = tripRepository.findById(id);
        if (!trip.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   tripRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);}
    }

    @Override
    public ResponseEntity UpdateTrip(Integer id, Trip newTrip) {
        Optional<Trip> trip = tripRepository.findById(id);
        if (!trip.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   newTrip.setId(id);
            Trip trip1=tripRepository.save(newTrip);
            return new ResponseEntity(trip1,HttpStatus.ACCEPTED);}
    }

    @Override
    public ResponseEntity FindTrip(Integer id) {
        Optional<Trip> trip=tripRepository.findById(id);
        if(!trip.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(trip.get(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity <List<Trip>>FindTripByDriver(String id) {
        List<Trip>list=tripRepository.findByDriverUserNameOrderByDepartureDateTime(id);
        if (list.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list,HttpStatus.OK) ;
    }
    public ResponseEntity <List<Trip>>FindTripByGuide(String id) {
        List<Trip>list=tripRepository.findByGuideUserNameOrderByDepartureDateTime(id);
        if (list.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list,HttpStatus.OK) ;
    }
}
