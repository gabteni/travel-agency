package isg.pfe.travelAgency.ServicesImplementation;

import isg.pfe.travelAgency.Entities.Guest;
import isg.pfe.travelAgency.Repositories.GuestRepository;
import isg.pfe.travelAgency.Services.GuestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestServiecesImpl implements GuestServices {
    @Autowired
    GuestRepository guestRepository;
    @Override
    public ResponseEntity<?> SaveGuest(Guest guest) {
        return new ResponseEntity<>(guestRepository.save(guest), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Guest>> ListGuests() {
        List<Guest>list=guestRepository.findAll();
        if (list.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list,HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity DeleteGuest(Long id) {
        Optional<Guest> guest = guestRepository.findById(id);
        if (!guest.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   guestRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);}
    }

    @Override
    public ResponseEntity UpdateGuest(Long id, Guest newGuest) {
        Optional<Guest> guest = guestRepository.findById(id);
        if (!guest.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   newGuest.setId(id);
            Guest guest1=guestRepository.save(newGuest);
            return new ResponseEntity(guest1,HttpStatus.ACCEPTED);}
    }

    @Override
    public ResponseEntity FindGuest(Long id) {
        Optional<Guest> guest=guestRepository.findById(id);
        if(!guest.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(guest.get(),HttpStatus.OK);
    }



}
