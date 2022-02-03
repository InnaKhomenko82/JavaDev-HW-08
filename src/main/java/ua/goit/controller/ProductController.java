package ua.goit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.models.Product;
import ua.goit.repository.ProductRepository;
import ua.goit.service.ProductService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "product")
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    @GetMapping//(value = {"products"})
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping({"/{id}", "/"})
    public Optional<Product> findById(@PathVariable(required = false, name = "id")
                                      Optional<Long> id){
        if (id.isPresent()) {
            return productService.findById(id.get());
        }
        else return productService.findById(2L);
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }
}
