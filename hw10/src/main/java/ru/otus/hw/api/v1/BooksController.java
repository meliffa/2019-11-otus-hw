package ru.otus.hw.api.v1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.hw.dto.BookDTO;
import ru.otus.hw.service.book.BookProvider;
import java.util.List;

/**
 * Created by Inna Spodarik on 01.03.2020.
 */
@RestController("BooksController_v1")
@RequestMapping("/books/v1")
public class BooksController {
    private Logger logger = LogManager.getLogger();

    private final BookProvider bookProvider;

    public BooksController(BookProvider provider) {
        this.bookProvider = provider;
    }

    @GetMapping
    public List<BookDTO> getBooks(Model model) {
        return bookProvider.getAll();
    }
}
