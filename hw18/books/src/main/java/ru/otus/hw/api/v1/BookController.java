package ru.otus.hw.api.v1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.otus.hw.dto.BookDTO;
import ru.otus.hw.service.book.BookProvider;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Inna Spodarik on 29.02.2020.
 */
@RequestMapping("/book")
@Controller("BookController_v1")
public class BookController {
    private Logger logger = LogManager.getLogger();

    private final BookProvider bookProvider;

    public BookController(BookProvider provider) {
        this.bookProvider = provider;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getBooks() {
        try {
            List<BookDTO> books = bookProvider.getAll();
            return books.size() > 0 ?
                    ResponseEntity.status(HttpStatus.OK).body(books)
                    :
                    ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable Integer bookId) {
        try {
            BookDTO book = bookProvider.getById(bookId);
            return book != null ?
                    ResponseEntity.status(HttpStatus.OK).body(book)
                    :
                    ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<?> getBookByAuthorId(@PathVariable Integer authorId) {
        try {
            List<BookDTO> books = bookProvider.getByAuthorId(authorId);
            return books.size() > 0 ?
                    ResponseEntity.status(HttpStatus.OK).body(books)
                    :
                    ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/book/delete/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer bookId) {
        try {
            bookProvider.deleteById(bookId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
