package isg.pfe.travelAgency.Services;

import isg.pfe.travelAgency.Entities.Driver;
import isg.pfe.travelAgency.Entities.Guide;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GuideServices {
    ResponseEntity<?> SaveGuide(Guide guide);
    ResponseEntity<List<Guide>> ListGuides();
    ResponseEntity DeleteGuide(Integer id);
    ResponseEntity UpdateGuide(Integer id, Guide newGuide);
    ResponseEntity FindGuide(Integer id);
}
