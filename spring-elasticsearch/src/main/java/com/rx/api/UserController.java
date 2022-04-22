package com.rx.api;

import com.rx.model.User;
import com.rx.repo.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init(){
        User.builder().id("01")
                .name("Ramazan")
                .surname("Özcan")
                .address("Ankara")
                .birthday(Calendar.getInstance().getTime())
                .build();
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<User>> getUsers(@PathVariable String search){
        //return ResponseEntity.ok(userRepository.getByCustomQuery(search));
        return ResponseEntity.ok(userRepository.findByNameLikeOrSurnameLike(search, search));
    }


}
