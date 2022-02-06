package ua.goit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.models.Producer;
import ua.goit.models.Product;
import ua.goit.service.ProducerService;
import ua.goit.service.ProductService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "product")
public class ProductController {

    private final ProductService productService;
    private final ProducerService producerService;

    @GetMapping//(value = {"products"})
    public ModelAndView findAll(ModelAndView model){
        List<Product> products = productService.findAll();
        model.addObject("products", products);
        model.setViewName("product/products");
        return model;
    }

    @GetMapping({"/{id}"})
    public ModelAndView findById
            (@PathVariable(required = false, name = "id")
                     Long id, ModelAndView model){
        List<Producer> producers = producerService.findAll();
        Optional<Product> product = productService.findById(id);
            model.addObject("product", product.get());
            model.addObject("listProducer",producers);
            model.setViewName("product/product");
        return model;
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }
}
