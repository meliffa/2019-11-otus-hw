package ru.otus.hw.db.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import ru.otus.hw.db.entity.Book;

/**
 * Created by Inna Spodarik on 24.02.2020.
 */
public interface BookRepository extends ReactiveMongoRepository<Book, String> {
    Flux<Book> findByBookNameIgnoreCase(String bookName);
}
