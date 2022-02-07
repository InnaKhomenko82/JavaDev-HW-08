package ua.goit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.goit.models.Producer;
import ua.goit.service.ProducerService;
import ua.goit.utils.HandleBodyUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "producer")
public class ProducerController {

    private final ProducerService producerService;

    @GetMapping
    public ModelAndView findAll(ModelAndView model){
        List<Producer> producers = producerService.findAll();
        model.addObject("producers", producers);
        model.setViewName("producer/producers");
        return model;
    }

    @GetMapping({"/{id}"})
    public ModelAndView findById
            (@PathVariable(required = false, name = "id")
                     Long id, ModelAndView model){
        Optional<Producer> producer = producerService.findById(id);
        model.addObject("producer", producer.get());
        model.setViewName("producer/producer");
        return model;
    }

    @GetMapping("new")
    public ModelAndView newItem (Producer producer, ModelAndView model){
        model.addObject("producer", producer);
        model.setViewName("producer/producer");
        return model;
    }

    @PostMapping
    public RedirectView post(HttpServletRequest req) throws IOException {
        System.out.println("post");
        HandleBodyUtil.getModelFromStream(req.getInputStream(), Producer.class)
                .ifPresent(producerService::save);
        return new RedirectView("producer/producers");
    }

    @PutMapping("/{id}")
    public RedirectView put(HttpServletRequest req, @PathVariable Long id) throws IOException {
        System.out.println("put");
        HandleBodyUtil.getModelFromStream(req.getInputStream(), Producer.class)
                .ifPresent(producerService::save);
        return new RedirectView("producer/producers");
    }

    @GetMapping("delete={id}")
    public RedirectView delete(@PathVariable Long id){
        producerService.deleteById(id);
        return new RedirectView("");
    }
}
