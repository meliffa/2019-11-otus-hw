package ru.otus.hw.jpa.repository.book;

import ru.otus.hw.jpa.entity.Book;
import java.util.List;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
public interface BookRepository {
    Book getById(Integer bookId);
    List<Book> getByName(String bookName);
    void insert(Book book);
    void update(Book book);
    void deleteById(Integer bookId);
    List<Book> getAll();
}
