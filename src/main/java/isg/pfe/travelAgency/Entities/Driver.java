package isg.pfe.travelAgency.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
public class Driver extends UserU {
    private LocalDate birthDate;
    private String status;
    private String phoneNum;
    private String email;
    @Column(name = "picByte", length = 1000)
    private byte[] picByte;
    private String management;
    private LocalDate startContract;
    private LocalDate endContract;
    private LocalDate PCEndDate;

    @OneToMany(mappedBy = "driver",cascade =   {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,

    })
    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
    private List<Trip> trips;
    public Driver(String userName,String pass){
        this.setPassword(pass);
        this.setUserName(userName);
    }

}   
