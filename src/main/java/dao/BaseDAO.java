package dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BaseDAO<T> {
    List<T> readAll();

    Optional<T> readById(Long id);

    T create(T entity);

    T update(T entity);

    boolean deleteById(Long id);

    boolean existById(Long id);
}
