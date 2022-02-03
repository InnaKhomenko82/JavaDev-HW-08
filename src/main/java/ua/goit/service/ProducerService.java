package ua.goit.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.goit.models.Producer;

@Service
public class ProducerService extends BaseService<Producer,Long>{
    public ProducerService(CrudRepository<Producer, Long> repository) {
        super(repository);
    }
}
