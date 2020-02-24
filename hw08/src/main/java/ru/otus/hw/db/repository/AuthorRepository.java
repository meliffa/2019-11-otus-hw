package ru.otus.hw.db.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw.db.entity.Author;

import java.util.List;
import java.util.Optional;

/**
 * Created by Inna Spodarik on 24.02.2020.
 */
public interface AuthorRepository extends MongoRepository<Author, String> {
    Optional<Author> findByAuthorNameIgnoreCase(String authorName);
}
