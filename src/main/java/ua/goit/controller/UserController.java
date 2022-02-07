package ua.goit.controller;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.goit.models.User;
import ua.goit.service.UserService;

import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "user")
public class UserController {

    private final UserService userService;

    @GetMapping//(value = {"users"})
    public ModelAndView findAll(ModelAndView model){
        model.addObject("users",userService.findAll());
        model.setViewName("user/users");
        return model;
    }

    @GetMapping({"/{id}"})
    public ModelAndView findById
            (@ApiParam(required = true, defaultValue = "2")
             @PathVariable(required = false, name = "id")
                     Long id, ModelAndView model){
        Optional<User> user = userService.findById(id);
        model.addObject("user", user.get());
        model.setViewName("user/user");
        return model;
    }

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("delete={id}")
    public RedirectView delete(@PathVariable Long id){
        userService.deleteById(id);
        return new RedirectView("");
    }
}
