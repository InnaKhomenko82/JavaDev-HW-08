package ua.goit.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.goit.models.Product;

@Service
public class ProductService extends BaseService<Product,Long>{

    public ProductService(CrudRepository<Product, Long> repository) {
        super(repository);
    }
}
