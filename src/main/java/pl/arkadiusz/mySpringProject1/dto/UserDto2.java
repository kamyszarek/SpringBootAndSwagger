package pl.arkadiusz.mySpringProject1.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.arkadiusz.mySpringProject1.model.Address;
import pl.arkadiusz.mySpringProject1.model.Facture;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Builder
public class UserDto2 {

    private long id;

    private String name;
    private String surname;
    private String username;
    private String password;

    List<Facture> facture;
    List<Address> address;
}
