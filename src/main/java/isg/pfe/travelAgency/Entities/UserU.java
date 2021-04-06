package isg.pfe.travelAgency.Entities;

import lombok.*;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UserU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String userName;
     @Column(nullable = false)
    private String password;

    private String role;
    private String NIC;


    public UserU(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
