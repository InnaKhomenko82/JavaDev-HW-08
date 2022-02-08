package ua.goit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.goit.models.User;
import ua.goit.service.UserService;

import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ModelAndView findAll(ModelAndView model){
        model.addObject("users",userService.findAll());
        model.setViewName("user/users");
        return model;
    }

    @GetMapping({"/{id}"})
    public ModelAndView findById
            (@PathVariable(required = false, name = "id")
                     UUID id, ModelAndView model){
        Optional<User> user = userService.findById(id);
        model.addObject("user", user.get());
        model.setViewName("user/user");
        return model;
    }

    @GetMapping("new")
    public ModelAndView newItem (User user, ModelAndView model){
        model.addObject("user", user);
        model.setViewName("user/user");
        return model;
    }

    @PostMapping({"new", "/{id}"})
    public RedirectView post(@ModelAttribute ("user") User user) {
        userService.save(user);
        return new RedirectView("");
    }

    @GetMapping("delete={id}")
    public RedirectView delete(@PathVariable UUID id){
        userService.deleteById(id);
        return new RedirectView("");
    }
}