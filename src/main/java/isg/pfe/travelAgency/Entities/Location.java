package isg.pfe.travelAgency.Entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.lang.Nullable;
import com.google.maps.model.DistanceMatrix;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","trips1","guests"})
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String cityArea;
    private int postalCode;
    private String phoneNumber;
    private String address;
    private String name;
    private float latitude;
    private float longitude;
    private String email;

   @OneToMany(/*mappedBy = "destination"*/targetEntity = Trip.class)
    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")

    private Set<Trip> trips;
    @OneToMany(mappedBy = "currentPickUpLocation",cascade = CascadeType.ALL)
   //@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
    private Set<Guest> guests;

    @ManyToMany(mappedBy = "route",cascade = CascadeType.ALL)
    //@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
    public List<Trip>trips1;

    /*@OneToMany(mappedBy = "location")
    Set<Trip>routes;*/


}
