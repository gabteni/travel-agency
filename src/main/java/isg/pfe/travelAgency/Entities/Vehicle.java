package isg.pfe.travelAgency.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter

@RequiredArgsConstructor
@Entity
public class    Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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

    @OneToMany(mappedBy = "vehicle",cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
    private List<Trip> trips;
    }
