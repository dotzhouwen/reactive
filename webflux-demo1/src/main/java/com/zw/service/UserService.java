package com.zw.service;

import com.zw.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> getUserById(Integer id);

    Flux<User> getAllUsers();

    Mono<Void> saveUser(Mono<User> userMono);
}
