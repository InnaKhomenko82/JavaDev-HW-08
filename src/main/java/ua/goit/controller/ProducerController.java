package ua.goit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
    public List<Producer> findAll(){
        return producerService.findAll();
    }

    @GetMapping({"/{id}", "/"})
    public Optional<Producer> findById
            (@PathVariable(required = false, name = "id") Long id){
            return producerService.findById(id);
    }

    @PostMapping
    public Producer save(@RequestBody Producer producer){
        return producerService.save(producer);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") Long id){
        producerService.deleteById(id);
    }
}
