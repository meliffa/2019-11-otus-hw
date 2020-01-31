package ru.otus.hw.service.book;

import org.springframework.stereotype.Service;
import ru.otus.hw.db.book.BookDBProvider;
import ru.otus.hw.entity.Author;
import ru.otus.hw.entity.Book;
import ru.otus.hw.entity.Genre;

import java.util.List;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Service
public class BookImpl implements BookProvider {

    private final BookDBProvider dbBookProvider;

    public BookImpl(BookDBProvider dbBookProvider) {
        this.dbBookProvider = dbBookProvider;
    }

    @Override
    public void createBook(Book book) {
        dbBookProvider.insertBook(book);
    }

    @Override
    public List<Book> getBooksByName(String bookName) {
        return dbBookProvider.getBooksByName(bookName);
    }

    @Override
    public Book getBookById(Integer bookId) {
        return dbBookProvider.getBookById(bookId);
    }

    @Override
    public void deleteBookById(Integer bookId) {
        dbBookProvider.deleteBookById(bookId);
    }

    @Override
    public List<Book> listBooks() {
        return dbBookProvider.getAllBooks();
    }

    @Override
    public void updateBook(Integer bookId, Author author, Genre genre, String bookName){
        if (author != null) dbBookProvider.updateBookAuthor(bookId, author.getAuthorId());
        if (genre != null) dbBookProvider.updateBookGenre(bookId, genre.getGenreId());
        if (bookName != null) dbBookProvider.updateBookName(bookId, bookName);
    }
}
