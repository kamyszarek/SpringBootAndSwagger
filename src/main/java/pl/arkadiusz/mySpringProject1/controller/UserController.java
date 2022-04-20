package pl.arkadiusz.mySpringProject1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.arkadiusz.mySpringProject1.dto.UserDto;
import pl.arkadiusz.mySpringProject1.dto.UserDto2;
import pl.arkadiusz.mySpringProject1.dto.UserDtoMapper;
import pl.arkadiusz.mySpringProject1.model.Address;
import pl.arkadiusz.mySpringProject1.model.User;
import pl.arkadiusz.mySpringProject1.model.service.UserService;
import pl.arkadiusz.mySpringProject1.repository.AddressRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AddressRepository addressRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/usersDto")
    public List<UserDto> getUsersDto() {
        return UserDtoMapper.mapToUserDtos(userService.getUsers());
    }

    @GetMapping("/Users&Addresses")
    public List<UserDto2> getUaA() {
        return userService.getUaA();
    }

    @GetMapping("/getUsers&Factures")
    public List<UserDto2> getUaF(){
        return userService.getUaF();
    }

    @GetMapping("/getUsers&Addresses&Factures")
    public List<UserDto2> getUaAaF(){
        return userService.getUaAaF();
    }


    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/addaddress")
    public Address addAddress(@RequestBody Address address) {
        return userService.addAddress(address);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

}
