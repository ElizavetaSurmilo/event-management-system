package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.UserDTO;
import org.example.entity.Users;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Users create(UserDTO dto) {
        Users user = Users.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .build();
        return userRepository.save(user);
    }

    public List<Users> readAll() {
        return userRepository.findAll();
    }

    public Users update(Users user) {
        return userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public Users readById(Integer id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found - " + id));
    }
}
