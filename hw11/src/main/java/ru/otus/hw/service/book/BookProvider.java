package ru.otus.hw.service.book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.hw.db.entity.Book;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public interface BookProvider {
    Mono<Book> create(Book book);
    Mono<Book> getById(String id);
    Flux<Book> getByName(String name);
    Mono<Book> update(Book book);
    Mono<Void> deleteById(String id);
    Flux<Book> getAll();
}
