package isg.pfe.travelAgency.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity

public class Route {
    @EmbeddedId
    public RouteKey id=new RouteKey();

    @ManyToOne
    @MapsId("locationId")
    @JoinColumn(name = "location_id")
    public Location location;

    @ManyToOne
    @MapsId("tripId")
    @JoinColumn(name = "trip_id")
    public Trip trip;
    int xd;
}
