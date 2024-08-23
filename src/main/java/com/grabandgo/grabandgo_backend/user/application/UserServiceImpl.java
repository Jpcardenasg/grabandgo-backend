package com.grabandgo.grabandgo_backend.user.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.user.domain.DTO.UserDTO;
import com.grabandgo.grabandgo_backend.user.domain.DTO.UserRegistrationDTO;
import com.grabandgo.grabandgo_backend.user.domain.Role;
import com.grabandgo.grabandgo_backend.user.domain.User;
import com.grabandgo.grabandgo_backend.user.infrastructure.out.UserRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void saveUser(UserRegistrationDTO userDTO) {
        User user = toEntity(userDTO);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void updateUser(Long id, UserRegistrationDTO userDTO) {
        if (userRepository.existsById(id)) {
            User user = toEntity(userDTO);
            user.setId(id);
            userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Optional<UserDTO> findUserById(Long id) {
        return userRepository.findById(id).map(this::toDTO);
    }

    @Transactional
    @Override
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public User toEntity(UserRegistrationDTO userRegistrationDTO) {

        User user = new User();
        user.setUsername(userRegistrationDTO.getUsername());
        user.setPassword(userRegistrationDTO.getPassword());
        user.setRole(Role.valueOf(userRegistrationDTO.getRole()));

        return user;
    }

    @Override
    public UserDTO toDTO(User user) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setRole(user.getRole().toString());

        return userDTO;
    }

}
