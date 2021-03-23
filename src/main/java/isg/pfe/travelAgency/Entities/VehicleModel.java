package isg.pfe.travelAgency.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelNumber;
    private String modelName;
    private String manufacturer;
    private int seatCount;
    private int fuelEco;
    @OneToMany(mappedBy = "model")
    private List<Vehicle> vehicles;

}
