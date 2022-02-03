package ua.goit.repository;

import org.springframework.data.repository.CrudRepository;
import ua.goit.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
