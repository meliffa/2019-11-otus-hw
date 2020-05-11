package ru.otus.hw.jpa.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.hw.jpa.entity.Book;
import java.util.List;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByBookName(String bookName);
    List<Book> findByAuthorId(Integer authorId);
}
