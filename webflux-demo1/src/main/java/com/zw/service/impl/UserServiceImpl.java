package com.zw.service.impl;

import com.zw.entity.User;
import com.zw.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final Map<Integer, User> users = new HashMap<>();

    @PostConstruct
    public void init() {
        this.users.put(1, User.builder().name("lucky").age(20).gender("男").build());
        this.users.put(2, User.builder().name("tom").age(21).gender("女").build());
        this.users.put(3, User.builder().name("john").age(28).gender("男").build());
        this.users.put(4, User.builder().name("jack").age(24).gender("男").build());
    }

    @Override
    public Mono<User> getUserById(Integer id) {
        return Mono.justOrEmpty(this.users.get(id));
    }

    @Override
    public Flux<User> getAllUsers() {
        return Flux.fromIterable(this.users.values());
    }

    @Override
    public Mono<Void> saveUser(Mono<User> userMono) {
        return userMono.doOnNext(person -> {
            int id = users.size() + 1;
            users.put(id, person);
        }).thenEmpty(Mono.empty());
    }
}
