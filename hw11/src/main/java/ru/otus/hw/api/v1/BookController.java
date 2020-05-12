package ru.otus.hw.api.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.hw.db.entity.Book;
import ru.otus.hw.service.book.BookProvider;

/**
 * Created by Inna Spodarik on 12.05.2020.
 */
@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookProvider bookProvider;

    @GetMapping("/books/v1")
    public Flux<Book> getBooks() {
        return bookProvider.getAll();
    }

    @GetMapping("/book/v1/{bookName}")
    public Flux<Book> getBooksByName(@PathVariable("bookName") String bookName) {
        return bookProvider.getByName(bookName);
    }

    @GetMapping("/books/v1/{id}")
    public Mono<Book> getBookById(@PathVariable("id") String id) {
        return bookProvider.getById(id);
    }

    @PostMapping("/book/v1")
    public Mono<Book> createBook(@RequestBody Book book) {
        return bookProvider.create(book);
    }

    @PutMapping("/book/v1")
    public Mono<Book> updateBook(@RequestBody Book book) {
        return bookProvider.update(book);
    }

    @DeleteMapping("book/v1/{id}")
    public Mono<Void> deleteBookById(@PathVariable("id") String id) {
        return bookProvider.deleteById(id);
    }
}
