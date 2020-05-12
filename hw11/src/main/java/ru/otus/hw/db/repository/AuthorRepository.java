package ru.otus.hw.db.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import ru.otus.hw.db.entity.Author;
/**
 * Created by Inna Spodarik on 24.02.2020.
 */
public interface AuthorRepository extends ReactiveMongoRepository<Author, String> {
    Mono<Author> findByAuthorNameIgnoreCase(String authorName);
}
