package ua.goit.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.goit.models.User;

@Service
public class UserService extends BaseService<User,Long>{


    public UserService(CrudRepository<User, Long> repository) {
        super(repository);
    }
}
