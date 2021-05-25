package isg.pfe.travelAgency.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class RouteKey implements Serializable {
    @Column(name = "location_id")
    Long locationId;

    @Column(name = "trip_id")
    Long tripId;
}
