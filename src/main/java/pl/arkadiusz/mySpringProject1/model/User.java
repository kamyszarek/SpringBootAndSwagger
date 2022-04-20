package pl.arkadiusz.mySpringProject1.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String surname;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    List<Facture> facture;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    List<Address> address;


}
