package ru.otus.hw.db.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw.db.entity.Book;

import java.util.List;

/**
 * Created by Inna Spodarik on 24.02.2020.
 */
public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findAllByAuthorAuthorId(String authorId);
    List<Book> findByBookName(String bookName);
}
