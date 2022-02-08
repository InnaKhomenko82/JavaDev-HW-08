package ua.goit.repository;

import org.springframework.data.repository.CrudRepository;
import ua.goit.models.Producer;

import java.util.UUID;

public interface ProducerRepository extends CrudRepository<Producer, UUID>{
}
