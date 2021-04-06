package isg.pfe.travelAgency.Controllers;


import isg.pfe.travelAgency.Entities.Guide;
import isg.pfe.travelAgency.Services.GuideServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/Guides")
public class GuideController {

    private final Logger Log = LoggerFactory.getLogger(Guide.class);
    @Autowired
    GuideServices guideServices;
    @GetMapping("/all")
    public ResponseEntity<List<Guide>> getAll(){
        return guideServices.ListGuides();
    }
    @PutMapping("/Update/{id}")
    public  ResponseEntity update(@PathVariable Long id,@RequestBody Guide guide){
        return guideServices.UpdateGuide(id,guide);
    }
    @PostMapping("/New")
    public  ResponseEntity<?> add(@RequestBody Guide guide){
        return guideServices.SaveGuide(guide);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return guideServices.DeleteGuide(id);
    }
    @GetMapping(value = "/find/{id}")
    public  ResponseEntity find(@PathVariable ("id")long id){
        Log.info("Request for finding gust {}",id);
        return guideServices.FindGuide(id);
    }
}
