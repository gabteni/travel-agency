package isg.pfe.travelAgency.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.lang.Nullable;
import com.google.maps.model.DistanceMatrix;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    private List<Trip> trips;
    @OneToMany(mappedBy = "currentPickUpLocation",cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
    private List<Guest> guests;
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name = "location_trip",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "trip_id"))
    public List<Trip>trips1;


}
