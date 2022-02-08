package ua.goit.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.goit.models.Producer;

import java.util.UUID;

@Service
public class ProducerService extends BaseService<Producer,UUID>{
    public ProducerService(CrudRepository<Producer, UUID> repository) {
        super(repository);
    }
}
