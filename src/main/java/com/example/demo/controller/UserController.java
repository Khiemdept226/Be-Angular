package com.example.demo.controller;

import com.example.demo.Entity.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<Iterable<User>> getUser(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        Optional<User> userOptional = userService.findById(id);
        System.out.println(id);
        return userOptional.map(user1 -> {
            user.setId(user1.getId());
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));}
    @DeleteMapping("/delete/{id}")
        public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
            Optional<User> userOptional = userService.findById(id);
            return userOptional.map(user-> {
                userService.remove(id);
                return new ResponseEntity<>(user, HttpStatus.OK);
            }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
