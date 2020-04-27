package ru.otus.hw.service.processor;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import ru.otus.hw.db.mongo.entity.Book;
import ru.otus.hw.db.mongo.entity.Comment;
import ru.otus.hw.db.mongo.entity.CommentExt;
import ru.otus.hw.db.mongo.repository.BookRepository;

/**
 * Created by Inna Spodarik on 21.04.2020.
 */
@Component
@RequiredArgsConstructor
public class CommentProcessor implements ItemProcessor<Comment, CommentExt> {

    private final BookRepository bookRepository;

    public CommentExt process(Comment comment) {
        Book book = bookRepository.findBookByCommentId(comment.getCommentId());

        if (book != null) {
            CommentExt commentExt = new CommentExt();
            commentExt.setCommentId(comment.getCommentId());
            commentExt.setComment(comment.getComment());
            commentExt.setBookId(book.getBookId());
            return commentExt;
        } else {
            return null;
        }
    }
}
