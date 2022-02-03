package ua.goit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.models.Producer;
import ua.goit.models.User;
import ua.goit.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "user")
public class UserController {

    private final UserService userService;

    @GetMapping//(value = {"users"})
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }
}
