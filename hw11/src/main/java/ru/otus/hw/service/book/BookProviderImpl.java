package ru.otus.hw.service.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.hw.db.entity.Book;
import ru.otus.hw.db.repository.BookRepository;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Service
@RequiredArgsConstructor
public class BookProviderImpl implements BookProvider {

    private final BookRepository bookRepository;

    @Override
    public Mono<Book> create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Mono<Book> getById(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public Flux<Book> getByName(String name) {
        return bookRepository.findByBookNameIgnoreCase(name);
    }

    @Override
    public Mono<Book> update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return bookRepository.deleteById(id);
    }

    @Override
    public Flux<Book> getAll() {
        return bookRepository.findAll();
    }
}
