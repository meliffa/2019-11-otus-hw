package ru.otus.hw.service.genre;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.hw.db.entity.Genre;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public interface GenreProvider {
    Mono<Genre> getByName(String name);
    Flux<Genre> getAll();
}
