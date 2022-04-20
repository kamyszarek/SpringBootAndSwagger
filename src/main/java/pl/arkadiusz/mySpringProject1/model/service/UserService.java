package pl.arkadiusz.mySpringProject1.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arkadiusz.mySpringProject1.dto.UserDto;
import pl.arkadiusz.mySpringProject1.dto.UserDto2;
import pl.arkadiusz.mySpringProject1.dto.UserDtoMapper;
import pl.arkadiusz.mySpringProject1.dto.UserDtoMapper2;
import pl.arkadiusz.mySpringProject1.model.Address;
import pl.arkadiusz.mySpringProject1.model.Facture;
import pl.arkadiusz.mySpringProject1.model.User;
import pl.arkadiusz.mySpringProject1.repository.AddressRepository;
import pl.arkadiusz.mySpringProject1.repository.FactureRepository;
import pl.arkadiusz.mySpringProject1.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final FactureRepository factureRepository;
    private final AddressRepository addressRepository;


    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<UserDto2> getUaA() {
        List<UserDto2> allUsers = UserDtoMapper2.mapToUserDtos(getUsers());
        List<Long> ids = allUsers.stream()
                .map(UserDto2::getId)
                .collect(Collectors.toList());
        List<Address> addresses = addressRepository.findAllByUserIdIn(ids);
        allUsers.forEach(user -> user.setAddress(extractAddress(addresses, user.getId())));

        return allUsers;
    }

    public List<UserDto2> getUaF() {
        List<UserDto2> allUsers = UserDtoMapper2.mapToUserDtos(getUsers());
        List<Long> ids = allUsers.stream()
                .map(UserDto2::getId)
                .collect(Collectors.toList());
        List<Facture> factures = factureRepository.findAllByUserIdIn(ids);
        allUsers.forEach(user -> user.setFacture(extractFacture(factures, user.getId())));

        return allUsers;
    }

    public List<UserDto2> getUaAaF() {
        List<UserDto2> allUsers = UserDtoMapper2.mapToUserDtos(getUsers());
        List<Long> ids = allUsers.stream()
                .map(UserDto2::getId)
                .collect(Collectors.toList());
        List<Address> addresses = addressRepository.findAllByUserIdIn(ids);
        List<Facture> factures = factureRepository.findAllByUserIdIn(ids);
        allUsers.forEach(user -> user.setAddress(extractAddress(addresses, user.getId())));
        allUsers.forEach(user -> user.setFacture(extractFacture(factures, user.getId())));

        return allUsers;
    }

    private List<Address> extractAddress(List<Address> addresses, long id) {
        return addresses.stream()
                .filter(address -> address.getUserId() == id)
                .collect(Collectors.toList());
    }

    private List<Facture> extractFacture(List<Facture> factures, long id) {
        return factures.stream()
                .filter(facture -> facture.getUserId() == id)
                .collect(Collectors.toList());
    }


    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }


    public User addUser(User user) {
        return userRepository.save(user);
    }

    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

}
