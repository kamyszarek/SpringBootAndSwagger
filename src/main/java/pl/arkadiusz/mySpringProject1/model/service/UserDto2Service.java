package pl.arkadiusz.mySpringProject1.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arkadiusz.mySpringProject1.dto.UserDto2;
import pl.arkadiusz.mySpringProject1.dto.UserDtoMapper2;
import pl.arkadiusz.mySpringProject1.model.Address;
import pl.arkadiusz.mySpringProject1.model.User;
import pl.arkadiusz.mySpringProject1.repository.AddressRepository;
import pl.arkadiusz.mySpringProject1.repository.FactureRepository;
import pl.arkadiusz.mySpringProject1.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDto2Service {

    private final UserRepository userRepository;
    private final FactureRepository factureRepository;
    private final AddressRepository addressRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<UserDto2> getUAF() {
        List<UserDto2> allUsers = UserDtoMapper2.mapToUserDtos(getUsers());
        List<Long> ids = allUsers.stream()
                .map(UserDto2::getId)
                .collect(Collectors.toList());
        List<Address> addresses = addressRepository.findAllByUserIdIn(ids);
        allUsers.forEach(user -> user.setAddress(extractAddress(addresses, user.getId())));

        return allUsers;
    }

    private List<Address> extractAddress(List<Address> addresses, long id) {
        return addresses.stream()
                .filter(address -> address.getUserId() == id)
                .collect(Collectors.toList());
    }

}
