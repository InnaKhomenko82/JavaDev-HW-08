package ua.goit.controller;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
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

//    @Operation(description = "hhh")
    @GetMapping//(value = {"producers"})
    public List<Producer> findAll(){
        return producerService.findAll();
    }

    @GetMapping({"/{id}"})
    public Optional<Producer> findById
            (@ApiParam(required = true, defaultValue = "2")
             @PathVariable(required = false, name = "id") Long id){
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
