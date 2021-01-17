package com.zw.handler;

import com.zw.entity.User;
import com.zw.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class UserHandler {
    private final UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public Mono<ServerResponse> getUserById(ServerRequest serverRequest) {
        Integer id = Integer.valueOf(serverRequest.pathVariable("id"));

        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<User> userMono = this.userService.getUserById(id);

        return userMono.flatMap(u -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(fromObject(u))).switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> getAllUsers() {
        Flux<User> allUsers = this.userService.getAllUsers();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(allUsers, User.class);
    }

    public Mono<ServerResponse> saveUser(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().build(this.userService.saveUser(userMono));
    }
}
