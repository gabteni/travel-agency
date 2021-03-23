package isg.pfe.travelAgency.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter

@RequiredArgsConstructor
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "vehiclemodel_id")
    public VehicleModel model;
    private String licencePlate;
    private String chassisNumber;
    private int seatCount;
    private String management;
    private Long distanceTravelled;//distance is stored in decimetre should be divided by 10 later on
    private String state;
    private LocalDate serviceStartDate;

    }
