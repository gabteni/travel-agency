package isg.pfe.travelAgency.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@AllArgsConstructor

public class Trip  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
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



    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name = "location_trip",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id"))
    public Set<Location> route;
    /*@OneToMany(mappedBy = "trip")
    Set<Route>routes ;*/

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name = "guest_trip",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id"))
    Set<Guest> guests;
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
    



}
