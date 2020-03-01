package ru.otus.hw.api.v1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.hw.dto.BookDTO;
import ru.otus.hw.service.author.AuthorProvider;
import ru.otus.hw.service.book.BookProvider;
import ru.otus.hw.service.genre.GenreProvider;

import java.util.List;

/**
 * Created by Inna Spodarik on 29.02.2020.
 */
@RestController("BookController_v1")
@RequestMapping("/book/v1")
public class BookController {
    private Logger logger = LogManager.getLogger();

    private final BookProvider bookProvider;
    public static final String BOOKS_HTML = "books";

    public BookController(BookProvider provider) {
        this.bookProvider = provider;
    }

    @PutMapping("/{bookId}")
    public void updateBook(@RequestBody BookDTO book) {
        bookProvider.update(book);
    }

    @PostMapping
    public void createBook(@RequestBody BookDTO book) {
        bookProvider.create(book);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Integer bookId) {
        bookProvider.deleteById(bookId);
    }
}
