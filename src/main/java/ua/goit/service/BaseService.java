package ua.goit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.goit.models.BaseEntity;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class BaseService <T extends BaseEntity, ID>{

    private final CrudRepository<T, ID> repository;

    public T save(T entity) {
        return repository.save (entity);
    }

    public List<T> findAll() {
        return (List<T>) repository.findAll();
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
