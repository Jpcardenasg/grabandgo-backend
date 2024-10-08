package com.grabandgo.grabandgo_backend.user.infrastructure.in;

import jakarta.validation.Valid;

import org.springframework.validation.annotation.Validated;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grabandgo.grabandgo_backend.user.application.UserService;
import com.grabandgo.grabandgo_backend.user.domain.User;

/**
 * UserController
 */
@Validated
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/updateUser/{UserId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId,
            @Valid @RequestBody User user) {
        userService.updateUser(userId, user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok(userId);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUserByid(@PathVariable Long id) {
        return ResponseEntity.of(userService.findById(id));
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

}