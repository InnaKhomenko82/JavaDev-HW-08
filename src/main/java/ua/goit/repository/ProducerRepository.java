package ua.goit.repository;

import org.springframework.data.repository.CrudRepository;
import ua.goit.models.Producer;

public interface ProducerRepository extends CrudRepository<Producer, Long>{
}
