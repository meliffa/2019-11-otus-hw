package ru.otus.hw.db.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import ru.otus.hw.db.entity.Genre;

/**
 * Created by Inna Spodarik on 24.02.2020.
 */
public interface GenreRepository extends ReactiveMongoRepository<Genre, String> {
    Mono<Genre> findByGenreNameIgnoreCase(String genreName);
}

