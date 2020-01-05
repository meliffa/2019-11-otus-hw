package ru.otus.hw.service.book;

import ru.otus.hw.entity.Author;
import ru.otus.hw.entity.Book;
import ru.otus.hw.entity.Genre;

import java.util.List;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public interface BookProvider {
    void createBook(Book book);
    Book getBookById(Integer bookId);
    Book getBookByName(String bookName);
    List<Book> listBooks();
    void deleteBookById(Integer bookId);
    void updateBook(Integer bookId, Author author, Genre genre, String bookName);
}
