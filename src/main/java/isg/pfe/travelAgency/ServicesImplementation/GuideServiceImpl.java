package isg.pfe.travelAgency.ServicesImplementation;

import isg.pfe.travelAgency.Entities.Guest;
import isg.pfe.travelAgency.Entities.Guide;
import isg.pfe.travelAgency.Repositories.GuestRepository;
import isg.pfe.travelAgency.Repositories.GuideRepository;
import isg.pfe.travelAgency.Services.GuideServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuideServiceImpl implements GuideServices {
    @Autowired
    GuideRepository guideRepository;
    @Override
    public ResponseEntity<?> SaveGuide(Guide guide) {
        return new ResponseEntity<>(guideRepository.save(guide), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Guide>> ListGuides() {
        List<Guide>list=guideRepository.findAll();
        if (list.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list,HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity DeleteGuide(Long id) {

        Optional<Guide> guide = guideRepository.findById(id);
        if (!guide.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   guideRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);}
    }

    @Override
    public ResponseEntity UpdateGuide(Long id, Guide newGuide) {
        Optional<Guide> guide = guideRepository.findById(id);
        if (!guide.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   newGuide.setId(id);
            Guide guide1=guideRepository.save(newGuide);
            return new ResponseEntity(guide1,HttpStatus.ACCEPTED);}
    }

    @Override
    public ResponseEntity FindGuide(Long id) {
        Optional<Guide> guide=guideRepository.findById(id);
        if(!guide.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(guide.get(),HttpStatus.OK);
    }
}
