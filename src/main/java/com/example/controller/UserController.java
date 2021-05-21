package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/blacklist")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> allUser(){
        return userService.findAllUser();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> findUser(@PathVariable int id){
        return ResponseEntity.ok(userService.findUser(id));
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(userService.create(user));
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user){
        if (userService.update(user) != null){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<User> delete(@PathVariable int id){
        User user = userService.delete(id);
        if (user != null){
            return ResponseEntity.ok().body(user);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

}
