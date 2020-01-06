package ru.otus.hw.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.hw.entity.Author;
import ru.otus.hw.entity.Book;
import ru.otus.hw.entity.Genre;
import ru.otus.hw.service.book.BookProvider;
import ru.otus.hw.utils.io.IOProvider;
import ru.otus.hw.utils.messages.MessageProvider;
import ru.otus.hw.utils.shell.ShellUtils;

import java.util.List;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@ShellComponent
public class BookShellCommander {
    private final MessageProvider messageProvider;
    private final IOProvider ioProvider;
    private final BookProvider bookProvider;
    private final ShellUtils shUtils;

    public BookShellCommander(MessageProvider messageProvider, IOProvider ioProvider,
                              BookProvider bookProvider, ShellUtils shUtils) {
        this.messageProvider = messageProvider;
        this.ioProvider = ioProvider;
        this.bookProvider = bookProvider;
        this.shUtils = shUtils;
    }

    @ShellMethod(key = {"bc", "bcr"}, value = "Create book")
    public void createBook() {
        Author author = shUtils.getAuthor();
        Genre genre = shUtils.getGenre();
        Book book = shUtils.getBook();
        book.setAuthor(author);
        book.setGenre(genre);
        bookProvider.createBook(book);
        ioProvider.print(messageProvider.getFormattedMessage("HW.BookCreated", book.getBookName()));
    }

    @ShellMethod(key = {"bg", "bgn"}, value = "Get books by name")
    public void getBooksByName(String bookName) {
        List<Book> books = bookProvider.getBooksByName(bookName);
        if (books.size() > 0) {
            books.forEach(b -> ioProvider.print(b.toString()));
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
            Genre genre = shUtils.getGenreForUpdate();
            Author author = shUtils.getAuthorForUpdate();
            String bookName = shUtils.getBookNameForUpdate();
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
}
