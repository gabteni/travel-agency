package isg.pfe.travelAgency.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime departureDateTime;
    LocalDateTime arrivalDateTime;
    @ManyToOne(/*fetch = FetchType.LAZY*/)
    @JoinColumn(name = "destination_id")
    public Location destination;
    @ManyToOne(/*fetch = FetchType.LAZY*/)
    @JoinColumn(name = "startlocation_id")
    public Location startLocation;
    /*  @JoinTable(
            name = "trip_location",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "trip_id"))
    List<Location> startDestination;*/
    @ManyToMany(mappedBy = "trips1",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public List<Location> route;


    @ManyToMany(mappedBy = "trips",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Guest> guests;
    @ManyToOne(/*fetch = FetchType.LAZY*/)
    @JoinColumn(name = "vehicle_id")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Vehicle vehicle;
    @ManyToOne(/*fetch = FetchType.LAZY*/)
    @JoinColumn(name = "guide_id")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Guide guide;
    @ManyToOne(/*fetch = FetchType.LAZY*/)
    @JoinColumn(name = "driver_id")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Driver driver;
    
    public Trip(Location destination,Location startLocation,Driver driver){
        this.destination=destination;
        this.startLocation=startLocation;
        this.driver=driver;

    }


}
