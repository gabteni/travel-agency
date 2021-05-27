package isg.pfe.travelAgency.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","trips"})
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String ageGroup;
    private LocalDate birthDate;
    private String phoneNum;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location currentPickUpLocation;

    @ManyToMany(mappedBy = "guests",cascade = CascadeType.ALL)
    private List<Trip> trips;
    public Guest(String xd_, String ageGrp) {
        this.name=xd_;
        this.ageGroup=ageGrp;
    }

}
