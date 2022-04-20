package pl.arkadiusz.mySpringProject1.dto;

import pl.arkadiusz.mySpringProject1.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDtoMapper2 {

    public UserDtoMapper2() {

    }

    public static List<UserDto2> mapToUserDtos(List<User> users) {
        return users.stream()
                .map(user -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private static UserDto2 mapToUserDto(User user) {
        return UserDto2.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }


}
