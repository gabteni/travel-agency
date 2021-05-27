package isg.pfe.travelAgency.ServicesImplementation;


import isg.pfe.travelAgency.Entities.Vehicle;
import isg.pfe.travelAgency.Entities.VehicleModel;
import isg.pfe.travelAgency.Repositories.VehicleModelRepository;

import isg.pfe.travelAgency.Services.VehicleModelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
 @Service
public class VehicleModelServicesImpl implements VehicleModelServices {
    @Autowired
    VehicleModelRepository vehicleModelRepository;
    @Override
    public ResponseEntity<?> SaveVehicleModel(VehicleModel vehicleModel) {
        return new ResponseEntity<>(vehicleModelRepository.save(vehicleModel), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<VehicleModel>> ListVehicleModel() {
        List< VehicleModel >list=vehicleModelRepository.findAll();
        if (list.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list,HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity DeleteVehicleModel(Integer id) {
        Optional<VehicleModel> vehicleModel = vehicleModelRepository.findById(id);
        if (!vehicleModel.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   vehicleModelRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);}

    }

    @Override
    public ResponseEntity UpdateVehicleModel(Integer id, VehicleModel newVehicleModel) {
        Optional<VehicleModel> vehicleModel = vehicleModelRepository.findById(id);
        if (!vehicleModel.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   newVehicleModel.setId(id);
            VehicleModel vehicleModel1=vehicleModelRepository.save(newVehicleModel);
            return new ResponseEntity(vehicleModel1,HttpStatus.ACCEPTED);}
    }

     @Override
     public ResponseEntity FindVehicleModel(Integer id) {
         Optional<VehicleModel> vehicleModel=vehicleModelRepository.findById(id);
         if(!vehicleModel.isPresent())
             return new ResponseEntity(HttpStatus.NOT_FOUND);
         return new ResponseEntity(vehicleModel.get(),HttpStatus.OK);
     }

 }
