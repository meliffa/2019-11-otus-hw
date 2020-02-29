package ru.otus.hw.service.comment;

import org.springframework.stereotype.Service;
import ru.otus.hw.db.entity.Book;
import ru.otus.hw.db.entity.Comment;
import ru.otus.hw.db.repository.BookRepository;
import ru.otus.hw.db.repository.CommentRepository;
import ru.otus.hw.dto.CommentDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
@Service
public class CommentProviderImpl implements CommentProvider {
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    public CommentProviderImpl(CommentRepository commentRepository, BookRepository bookRepository) {
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void create(CommentDTO comment) {
        commentRepository.save(comment.buildDBEntity());
    }

    @Override
    public CommentDTO getById(String id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        return comment != null ? comment.buildDTO() : null;
    }

    @Override
    public List<CommentDTO> getByBookId(String bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book != null && book.getComments() != null) {
            return book.getComments().stream()
                    .map(g -> g.buildDTO())
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public void update(CommentDTO comment) {
        commentRepository.save(comment.buildDBEntity());
    }

    @Override
    public void deleteById(String id) {
        commentRepository.deleteById(id);
        //bookRepository.deleteCommentFromBookById(id);
    }

    @Override
    public List<CommentDTO> getAll() {
        return commentRepository.findAll().stream()
                .map(g -> g.buildDTO())
                .collect(Collectors.toList());
    }
}
