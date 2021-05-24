package isg.pfe.travelAgency.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String ageGroup;
    private LocalDate birthDate;
    private String phoneNum;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location currentPickUpLocation;
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name = "guest_trip",
            joinColumns = @JoinColumn(name = "guest_id"),
            inverseJoinColumns = @JoinColumn(name = "trip_id"))
    private List<Trip> trips;
    public Guest(String xd_, String ageGrp) {
        this.name=xd_;
        this.ageGroup=ageGrp;
    }

}
