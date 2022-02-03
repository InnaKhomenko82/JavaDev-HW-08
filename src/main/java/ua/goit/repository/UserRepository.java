package ua.goit.repository;

import org.springframework.data.repository.CrudRepository;
import ua.goit.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
