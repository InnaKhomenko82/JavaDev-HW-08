package ua.goit.controller;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.goit.models.Producer;
import ua.goit.service.ProducerService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "producer")
public class ProducerController {

    private final ProducerService producerService;

    @GetMapping//(value = {"producers"})
    public ModelAndView findAll(ModelAndView model){
        List<Producer> producers = producerService.findAll();
        model.addObject("producers", producers);
        model.setViewName("producer/producers");
        return model;
    }

    @GetMapping({"/{id}"})
    public ModelAndView findById
            (@ApiParam(required = true, defaultValue = "2")
             @PathVariable(required = false, name = "id")
                     Long id, ModelAndView model){
        Optional<Producer> producer = producerService.findById(id);
        model.addObject("producer", producer.get());
        model.setViewName("producer/producer");
        return model;
    }

    @PostMapping("new")
    public String add(ModelAndView model, Producer producer){
        model.addObject("new", true);
        producerService.save(producer);
        return "new";
    }

    @PutMapping("/{id}")
    public RedirectView save(@RequestBody Producer producer){
        producerService.save(producer);
        return new RedirectView("producer/producers");
    }

    @GetMapping("delete={id}")
    public RedirectView delete(@PathVariable Long id){
        producerService.deleteById(id);
        return new RedirectView("");
    }
}
