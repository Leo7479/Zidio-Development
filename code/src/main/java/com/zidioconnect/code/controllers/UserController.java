package com.zidioconnect.code.controllers;

import com.zidioconnect.code.models.User;
import com.zidioconnect.code.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAll(){
        try{
            return userService.getAllUsers();
        }catch(Exception e){
            return null;
        }
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/search")
    public User getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }


    @PutMapping("/update")
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public User deleteById(@PathVariable long id){
        User user = userService.getUserById(id);
        userService.deleteUserById(id);
        return user;
    }
}