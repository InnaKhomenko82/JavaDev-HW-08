package ua.goit.repository;

import org.springframework.data.repository.CrudRepository;
import ua.goit.models.User;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
}
