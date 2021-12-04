package com.example.cinema.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users")
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {this.userService = userService;}

    @GetMapping
    public List<User> getUser(){return userService.getUsers();}

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody LoginForm loginForm)
    {
        return userService.login(loginForm);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){return userService.getUser(id);}

    @PostMapping
    public User createUser(@RequestBody User user){return userService.createUser(user);}

    @DeleteMapping("/{id}")
    public void deleteUser (@PathVariable String id){userService.deleteUser(id);}

    @PutMapping("/{id}")
    public void updateUser (@PathVariable String id, @RequestBody User data){userService.updateUser(id, data);}
}

class LoginForm{
    private String email;
    private String password;

    public LoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
