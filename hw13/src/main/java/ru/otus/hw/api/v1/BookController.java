package ru.otus.hw.api.v1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
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
@Controller("BookController_v1")
public class BookController {
    private Logger logger = LogManager.getLogger();

    private final BookProvider bookProvider;
    private final AuthorProvider authorProvider;
    private final GenreProvider genreProvider;
    public static final String BOOKS_HTML = "books";
    public static final String BOOK_EDIT_HTML = "bookEdit";
    private static final String BOOK_EDIT_HTML_REDIRECT = "redirect:/books/15";
    public BookController(BookProvider provider, AuthorProvider authorProvider, GenreProvider genreProvider) {
        this.bookProvider = provider;
        this.authorProvider = authorProvider;
        this.genreProvider = genreProvider;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping("/books")
    public String getBooks(Model model) {
        List<BookDTO> books = bookProvider.getAll();
        model.addAttribute("books", books);
        return BOOKS_HTML;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/book/edit/{bookId}")
    public String editBook(Model model, @PathVariable Integer bookId) {
        BookDTO book = bookProvider.getById(bookId);
        model.addAttribute("book", book);
        model.addAttribute("authors", authorProvider.getAll());
        model.addAttribute("genres", genreProvider.getAll());
        return BOOK_EDIT_HTML;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/book/save")
    public String saveBook(@ModelAttribute BookDTO book) {
        if (book.getBookId() != null) {
            bookProvider.update(book);
        } else {
            bookProvider.create(book);
        }
        return "redirect:/" + BOOKS_HTML;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/book/add")
    public String addBook(Model model) {
        model.addAttribute("book", new BookDTO());
        model.addAttribute("authors", authorProvider.getAll());
        model.addAttribute("genres", genreProvider.getAll());
        return BOOK_EDIT_HTML;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/book/delete/{bookId}")
    public String deleteBook(@PathVariable Integer bookId) {
        bookProvider.deleteById(bookId);
        return "redirect:/" + BOOKS_HTML;
    }
}
