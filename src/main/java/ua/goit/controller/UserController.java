package ua.goit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.goit.models.Role;
import ua.goit.models.User;
import ua.goit.service.UserService;
import ua.goit.utils.HandleBodyUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;


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
                     Long id, ModelAndView model){
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

    @PostMapping
    public RedirectView post(HttpServletRequest req) throws IOException {
        System.out.println("post");
        HandleBodyUtil.getModelFromStream(req.getInputStream(), User.class)
                .ifPresent(userService::save);
        return new RedirectView("user/users");
    }

    @PutMapping("/{id}")
    public RedirectView put(HttpServletRequest req, @PathVariable Long id) throws IOException {
        System.out.println("put");
        HandleBodyUtil.getModelFromStream(req.getInputStream(), User.class)
                .ifPresent(userService::save);
        return new RedirectView("user/users");
    }
    @GetMapping("delete={id}")
    public RedirectView delete(@PathVariable Long id){
        userService.deleteById(id);
        return new RedirectView("");
    }
}
