package com.sample.sampleapp.Controller;

import java.net.URI;
import java.util.Collection;

import java.net.URISyntaxException;
import java.util.Optional;

import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.sampleapp.Model.User;
import com.sample.sampleapp.Model.UserRepo;

/**
 * Description of this class.
 *
 * @author roundsquare
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RestController
@RequestMapping("/api")
public final class UserController {
    private UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/users")
    Collection<User> users() {
        return userRepo.findAll();
    }
    @GetMapping("/user/{id}")
    ResponseEntity<?> getUser(@Valid @PathVariable Long id) {
        Optional<User> user = userRepo.findById(id);
        return user.map(response -> ResponseEntity.ok().body(response))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/user")
    ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException {
        log.info("Request to create user: {}", user);
        if (!user.valid()) {
            log.info("User is not valid: {}", user);
            return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(user);
        }
        else { 
            User result = userRepo.save(user);
            return ResponseEntity.created(new URI("/api/user/" + result.getId())).body(result);
        } 
    }
    @PutMapping("/user/{id}")
    ResponseEntity<User> updateUser(@Valid @RequestBody User user, @PathVariable Long id) {
        log.info("Request to update user: {}", user);
        userRepo.deleteById(id);
        User result = userRepo.save(user);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/user/{id}")
    ResponseEntity<User> deleteUser(@Valid @PathVariable Long id) {
        log.info("Request to delete user: {}", id);
        userRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
