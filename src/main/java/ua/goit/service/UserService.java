package ua.goit.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.goit.models.User;

import java.util.UUID;

@Service
public class UserService extends BaseService<User, UUID>{

    private final BCryptPasswordEncoder encoder;

    public UserService(CrudRepository<User, UUID> repository, BCryptPasswordEncoder encoder) {
        super(repository);
        this.encoder = encoder;
    }
}