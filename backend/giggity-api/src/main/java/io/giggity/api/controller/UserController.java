package io.giggity.api.controller;

import io.giggity.api.model.User;
import io.giggity.api.service.UserService;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.net.URI;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    private final UserService svc;

    public UserController(UserService svc) {
        this.svc = svc;
    }

    @GetMapping
    public ResponseEntity<List<User>> list() {
        List<User> users = svc.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        User saved = svc.save(user);
        URI location = URI.create("/api/users/" + saved.getId());
        String eTag = "\"" + saved.getId() + "\"";
        return ResponseEntity.created(location)
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ETAG, eTag)
                .body(saved);
    }
}