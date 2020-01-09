package ru.otus.hw.db.book;

import ru.otus.hw.entity.Book;

import java.util.List;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public interface BookDBProvider {
    Book getBookById(Integer bookId);
    List<Book> getBooksByName(String bookName);
    void insertBook(Book book);
    void deleteBookById(Integer bookId);
    List<Book> getAllBooks();
    void updateBookAuthor(Integer bookId, Integer authorId);
    void updateBookGenre(Integer bookId, Integer genreId);
    void updateBookName(Integer bookId, String bookName);
}
