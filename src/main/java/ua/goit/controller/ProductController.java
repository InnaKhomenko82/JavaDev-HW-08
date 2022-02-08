package ua.goit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.goit.models.Product;
import ua.goit.service.ProducerService;
import ua.goit.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "product")
public class ProductController {

    private final ProductService productService;
    private final ProducerService producerService;

    @GetMapping
    public ModelAndView findAll(ModelAndView model){
        List<Product> products = productService.findAll();
        model.addObject("products", products);
        model.setViewName("product/products");
        return model;
    }

    @GetMapping({"/{id}"})
    public ModelAndView findById
            (@PathVariable(required = false, name = "id")
                     UUID id, ModelAndView model){Optional<Product> product = productService.findById(id);
            model.addObject("product", product.get());
            model.addObject("listProducer",producerService.findAll());
            model.setViewName("product/product");
        return model;
    }

    @GetMapping("new")
    public ModelAndView newItem (Product product, ModelAndView model){
        model.addObject("product", product);
        model.addObject("listProducer",producerService.findAll());
        model.setViewName("product/product");
        return model;
    }

    @PostMapping({"new", "/{id}"})
    public RedirectView post(@ModelAttribute ("product") Product product) {
        productService.save(product);
        return new RedirectView("");
    }

    @GetMapping("delete={id}")
    public RedirectView delete(@PathVariable UUID id){
        productService.deleteById(id);
        return new RedirectView("");
    }
}
