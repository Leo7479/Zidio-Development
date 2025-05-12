package com.zidioconnect.code.controllers;

import com.zidioconnect.code.models.User;
import com.zidioconnect.code.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/search")
    public User getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }

    // Combined search endpoint (optional)
    @GetMapping
    public User findUser(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String email) {
        if (id != null) {
            return userService.getUserById(id);
        }
        if (email != null) {
            return userService.getUserByEmail(email);
        }
        throw new IllegalArgumentException("Must provide either id or email");
    }
}