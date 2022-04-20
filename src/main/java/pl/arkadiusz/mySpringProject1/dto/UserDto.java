package pl.arkadiusz.mySpringProject1.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {

    private long id;

    private String name;
    private String surname;
    private String username;
    private String password;
}
