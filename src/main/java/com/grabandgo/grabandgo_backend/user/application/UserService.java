package com.grabandgo.grabandgo_backend.user.application;

import com.grabandgo.grabandgo_backend.user.domain.DTO.UserDTO;
import com.grabandgo.grabandgo_backend.user.domain.DTO.UserRegistrationDTO;
import com.grabandgo.grabandgo_backend.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void saveUser(UserRegistrationDTO userDTO);

    void updateUser(Long id, UserRegistrationDTO userDTO);

    void deleteUser(Long id);

    List<UserDTO> findAllUsers();

    Optional<UserDTO> findUserById(Long id);

    UserDTO toDTO(User user);

    User toEntity(UserRegistrationDTO userRegistrationDTO);
}