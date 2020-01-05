package ru.otus.hw.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.util.StringUtils;
import ru.otus.hw.entity.Author;
import ru.otus.hw.entity.Book;
import ru.otus.hw.entity.Genre;
import ru.otus.hw.service.author.AuthorProvider;
import ru.otus.hw.service.book.BookProvider;
import ru.otus.hw.service.genre.GenreProvider;
import ru.otus.hw.utils.io.IOProvider;
import ru.otus.hw.utils.messages.MessageProvider;

import java.util.List;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@ShellComponent
public class BookShellCommander {
    private final MessageProvider messageProvider;
    private final IOProvider ioProvider;
    private final AuthorProvider authorProvider;
    private final GenreProvider genreProvider;
    private final BookProvider bookProvider;

    public BookShellCommander(MessageProvider messageProvider, IOProvider ioProvider,
                              AuthorProvider authorProvider, GenreProvider genreProvider,
                              BookProvider bookProvider) {
        this.messageProvider = messageProvider;
        this.ioProvider = ioProvider;
        this.authorProvider = authorProvider;
        this.genreProvider = genreProvider;
        this.bookProvider = bookProvider;
    }

    @ShellMethod(key = {"bc", "bcr"}, value = "Create book")
    public void createBook() {
        Author author = getAuthor();
        Genre genre = getGenre();
        Book book = getBook();
        book.setAuthorId(author.getAuthorId());
        book.setGenreId(genre.getGenreId());
        bookProvider.createBook(book);
        ioProvider.print(messageProvider.getFormattedMessage("HW.BookCreated", book.getBookName()));
    }

    @ShellMethod(key = {"bg", "bgn"}, value = "Get book by name")
    public void getBookByName(String bookName) {
        Book book = bookProvider.getBookByName(bookName);
        if (book != null) {
            ioProvider.print(book.toString());
        } else {
            ioProvider.print(messageProvider.getFormattedMessage("HW.BookNotFoundByName", bookName));
        }
    }

    @ShellMethod(key = {"bgi", "bgid"}, value = "Get book by id")
    public void getBookById(Integer bookId) {
        Book book = bookProvider.getBookById(bookId);
        if (book != null) {
            ioProvider.print(book.toString());
        } else {
            ioProvider.print(messageProvider.getFormattedMessage("HW.BookNotFoundById", bookId.toString()));
        }
    }

    @ShellMethod(key = {"bb", "bl", "blist"}, value = "Browse all books")
    public void listBooks() {
        List<Book> books = bookProvider.listBooks();
        books.forEach(b -> ioProvider.print(b.toString()));
    }

    @ShellMethod(key = {"bd", "bdi"}, value = "Delete book by id")
    public void deleteBookById(Integer bookId) {
        Book book = bookProvider.getBookById(bookId);
        if (book != null) {
            bookProvider.deleteBookById(bookId);
            ioProvider.print(messageProvider.getFormattedMessage("HW.BookDeleted", bookId.toString()));
        } else {
            ioProvider.print(messageProvider.getFormattedMessage("HW.BookNotFoundById", bookId.toString()));
        }
    }

    @ShellMethod(key = {"bu", "bupd"}, value = "Update book by id")
    public void updateBookById(Integer bookId) {
        Book book = bookProvider.getBookById(bookId);
        if (book != null) {
            Genre genre = getGenreForUpdate();
            Author author = getAuthorForUpdate();
            String bookName = getBookNameForUpdate();
            if (genre != null || author != null || bookName != null) {
                bookProvider.updateBook(book.getBookId(), author, genre, bookName);
                ioProvider.print(messageProvider.getFormattedMessage("HW.BookUpdated", bookId.toString()));
            } else {
                ioProvider.print(messageProvider.getFormattedMessage("HW.BookNothingToUpdate", bookId.toString()));
            }
        } else {
            ioProvider.print(messageProvider.getFormattedMessage("HW.BookNotFoundById", bookId.toString()));
        }
    }

    private Book getBook() {
        ioProvider.print(messageProvider.getMessage("HW.EnterBookName"));
        boolean entered = false;
        while (!entered) {
            String bookName = ioProvider.read();
            if (StringUtils.isEmpty(bookName)) {
                ioProvider.print(messageProvider.getMessage("HW.BookNameNotEmpty"));
            } else {
                Book book = new Book(bookName);
                return book;
            }
        }
        throw new RuntimeException(messageProvider.getMessage("HW.DataEntryError"));
    }

    private Genre getGenre() {
        ioProvider.print(messageProvider.getMessage("HW.EnterGenreName"));
        boolean entered = false;
        while (!entered) {
            String genreName = ioProvider.read();
            if (StringUtils.isEmpty(genreName)) {
                ioProvider.print(messageProvider.getMessage("HW.GenreNameNotEmpty"));
            } else {
                Genre genre = genreProvider.getOrCreateGenreByName(genreName);
                return genre;
            }
        }
        throw new RuntimeException(messageProvider.getMessage("HW.DataEntryError"));
    }

    private Author getAuthor() {
        ioProvider.print(messageProvider.getMessage("HW.EnterAuthorName"));
        boolean entered = false;
        while (!entered) {
            String authorName = ioProvider.read();
            if (StringUtils.isEmpty(authorName)) {
                ioProvider.print(messageProvider.getMessage("HW.AuthorNameNotEmpty"));
            } else {
                Author author = authorProvider.getOrCreateAuthorByName(authorName);
                return author;
            }
        }
        throw new RuntimeException(messageProvider.getMessage("HW.DataEntryError"));
    }

    private String getBookNameForUpdate() {
        ioProvider.print(messageProvider.getMessage("HW.EnterBookName"));
        boolean entered = false;
        while (!entered) {
            String bookName = ioProvider.read();
            if (!StringUtils.isEmpty(bookName)) {
                return bookName;
            } else {
                entered = true;
            }
        }
        return null;
    }

    private Genre getGenreForUpdate() {
        ioProvider.print(messageProvider.getMessage("HW.EnterGenreName"));
        boolean entered = false;
        while (!entered) {
            String genreName = ioProvider.read();
            if (!StringUtils.isEmpty(genreName)) {
                Genre genre = genreProvider.getOrCreateGenreByName(genreName);
                return genre;
            } else {
                entered = true;
            }
        }
        return null;
    }

    private Author getAuthorForUpdate() {
        ioProvider.print(messageProvider.getMessage("HW.EnterAuthorName"));
        boolean entered = false;
        while (!entered) {
            String authorName = ioProvider.read();
            if (!StringUtils.isEmpty(authorName)) {
                Author author = authorProvider.getOrCreateAuthorByName(authorName);
                return author;
            } else {
                entered = true;
            }
        }
        return null;
    }
}
