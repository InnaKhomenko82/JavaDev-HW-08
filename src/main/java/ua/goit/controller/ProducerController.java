package ua.goit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.goit.models.Producer;
import ua.goit.service.ProducerService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public ModelAndView findById(@PathVariable(required = false, name = "id")
                                             UUID id, ModelAndView model){
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

    @PostMapping({"new", "/{id}"})
    public RedirectView post(@ModelAttribute ("producer") Producer producer) {
        producerService.save(producer);
        return new RedirectView("");
    }

    @GetMapping("delete={id}")
    public RedirectView delete(@PathVariable UUID id){
        producerService.deleteById(id);
        return new RedirectView("");
    }
}