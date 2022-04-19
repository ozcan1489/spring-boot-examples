package com.rx.api;

import com.rx.model.User;
import com.rx.repo.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@RequestParam String id){
        return ResponseEntity.ok(userRepository.findById(id));
    }

    @PostMapping()
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.ok(userRepository.save(user));
    }

    @DeleteMapping()
    public void deleteUser(@RequestParam User user){
        userRepository.delete(user);
    }
}
