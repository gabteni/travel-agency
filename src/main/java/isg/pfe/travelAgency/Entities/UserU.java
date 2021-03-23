package isg.pfe.travelAgency.Entities;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class UserU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String password;

    private String role;

    public UserU(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
