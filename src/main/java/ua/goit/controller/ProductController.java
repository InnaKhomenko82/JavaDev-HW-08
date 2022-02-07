package ua.goit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.goit.models.Product;
import ua.goit.service.ProducerService;
import ua.goit.service.ProductService;
import ua.goit.utils.HandleBodyUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
                     Long id, ModelAndView model){Optional<Product> product = productService.findById(id);
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

    @PostMapping
    public RedirectView post(HttpServletRequest req) throws IOException {
        System.out.println("post");
        HandleBodyUtil.getModelFromStream(req.getInputStream(), Product.class)
                .ifPresent(productService::save);
        return new RedirectView("producer/producers");
    }

    @PutMapping("/{id}")
    public RedirectView put(HttpServletRequest req, @PathVariable Long id) throws IOException {
        System.out.println("put");
        HandleBodyUtil.getModelFromStream(req.getInputStream(), Product.class)
                .ifPresent(productService::save);
        return new RedirectView("product/products");
    }

    @GetMapping("delete={id}")
    public RedirectView delete(@PathVariable Long id){
        productService.deleteById(id);
        return new RedirectView("");
    }
}
