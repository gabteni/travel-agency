package isg.pfe.travelAgency.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
public class Guide extends UserU{
    private LocalDate birthDate;
    private String status;
    private String phoneNum;
    private String email;
    @Column(name = "picByte", length = 1000)
    private byte[] picByte;
    private String management;
    private LocalDate startContract;
    private LocalDate endContract;
}
