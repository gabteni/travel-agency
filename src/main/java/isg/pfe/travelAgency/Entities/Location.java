package isg.pfe.travelAgency.Entities;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private String latitude;
    private String longitude;
    private String email;

}
