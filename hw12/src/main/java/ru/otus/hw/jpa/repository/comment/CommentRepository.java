package ru.otus.hw.jpa.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.hw.jpa.entity.Book;
import ru.otus.hw.jpa.entity.Comment;

import java.util.List;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByBook(Book book);
}
