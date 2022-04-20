package pl.arkadiusz.mySpringProject1.dto;

import pl.arkadiusz.mySpringProject1.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDtoMapper {

    public UserDtoMapper() {

    }

    public static List<UserDto> mapToUserDtos(List<User> users) {
        return users.stream()
                .map(user -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private static UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }


}
