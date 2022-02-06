package ua.goit.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.goit.models.User;

@Service
public class UserService extends BaseService<User,Long>{

    private final BCryptPasswordEncoder encoder;

    public UserService(CrudRepository<User, Long> repository, BCryptPasswordEncoder encoder) {
        super(repository);
        this.encoder = encoder;
    }
}
