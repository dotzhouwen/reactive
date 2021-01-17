package com.zw.controller;

import com.zw.entity.User;
import com.zw.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user/{id}")
    public Mono<User> getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users/")
    public Flux<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public Mono<Void> saveUser(@RequestBody User user) {
        Mono<User> userMono = Mono.just(user);
        return userService.saveUser(userMono);
    }
}
