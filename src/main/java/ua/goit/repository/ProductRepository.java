package ua.goit.repository;

import org.springframework.data.repository.CrudRepository;
import ua.goit.models.Product;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
