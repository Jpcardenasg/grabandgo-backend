package com.grabandgo.grabandgo_backend.user.infrastructure.in;

import com.grabandgo.grabandgo_backend.user.application.UserService;
import com.grabandgo.grabandgo_backend.user.domain.DTO.UserDTO;
import com.grabandgo.grabandgo_backend.user.domain.DTO.UserRegistrationDTO;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/saveUser")
    public ResponseEntity<UserRegistrationDTO> saveUser(@Valid @RequestBody UserRegistrationDTO userDTO) {

        try {
            service.saveUser(userDTO);
            return new ResponseEntity<>(userDTO, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<UserRegistrationDTO> updateUser(@PathVariable Long userId, @Valid @RequestBody UserRegistrationDTO userDTO) {

        try {
            service.updateUser(userId, userDTO);
            return  new ResponseEntity<>(userDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {

        try {
            service.deleteUser(userId);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDTO>> findAll() {

        try {
            List<UserDTO> userDTOs = service.findAllUsers();
            return new ResponseEntity<>(userDTOs, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long id) {

        try {
            UserDTO userDTO = service.findUserById(id).orElse(null);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}