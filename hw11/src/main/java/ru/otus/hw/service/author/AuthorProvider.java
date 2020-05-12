package ru.otus.hw.service.author;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.hw.db.entity.Author;
/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public interface AuthorProvider {
    Mono<Author> getByName(String name);
    Flux<Author> getAll();
}
