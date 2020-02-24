package ru.otus.hw.service.comment;

import org.springframework.stereotype.Service;
import ru.otus.hw.dto.CommentDTO;
import ru.otus.hw.jpa.entity.Comment;
import ru.otus.hw.jpa.repository.comment.CommentRepository;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
@Service
public class CommentProviderImpl implements CommentProvider {
    private final CommentRepository commentRepository;

    public CommentProviderImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void create(CommentDTO comment) {
        commentRepository.save(comment.buildJpaEntity());
    }

    @Override
    public CommentDTO getById(Integer id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        return comment != null ? comment.buildDTO() : null;
    }

    @Override
    public List<CommentDTO> getByBookId(Integer bookId) {
        return commentRepository.findByBookId(bookId).stream()
                .map(g -> g.buildDTO())
                .collect(Collectors.toList());
    }

    @Override
    public void update(CommentDTO comment) {
        commentRepository.save(comment.buildJpaEntity());
    }

    @Override
    public void deleteById(Integer id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<CommentDTO> getAll() {
        return commentRepository.findAll().stream()
                .map(g -> g.buildDTO())
                .collect(Collectors.toList());
    }
}
