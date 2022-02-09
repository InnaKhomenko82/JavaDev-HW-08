package ua.goit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.models.User;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping({"", "register"})
    public ModelAndView registerUserAccount(ModelAndView model) {
        User user = new User();
        model.addObject("user", user);
        model.setViewName("registration");
        return model;
    }

    @GetMapping("login")
    public ModelAndView logInUserAccount(ModelAndView model) {
        model.setViewName("login");
        return model;
    }
}
