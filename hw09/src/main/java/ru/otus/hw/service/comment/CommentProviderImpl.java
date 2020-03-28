package ru.otus.hw.service.comment;

import org.springframework.stereotype.Service;
import ru.otus.hw.dto.CommentDTO;
import ru.otus.hw.jpa.entity.Comment;
import ru.otus.hw.jpa.repository.comment.CommentRepository;
import ru.otus.hw.utils.DtoJpaConverter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
@Service
public class CommentProviderImpl implements CommentProvider {
    private final CommentRepository commentRepository;
    private final DtoJpaConverter converter;

    public CommentProviderImpl(CommentRepository commentRepository, DtoJpaConverter converter) {
        this.commentRepository = commentRepository;
        this.converter = converter;
    }

    @Override
    public void create(CommentDTO comment) {
        commentRepository.save(converter.convertToComment(comment));
    }

    @Override
    public CommentDTO getById(Integer id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        return comment != null ? converter.convertToCommentDto(comment) : null;
    }

    @Override
    public List<CommentDTO> getByBookId(Integer bookId) {
        return commentRepository.findByBookId(bookId).stream()
                .map(c -> converter.convertToCommentDto(c))
                .collect(Collectors.toList());
    }

    @Override
    public void update(CommentDTO comment) {
        commentRepository.save(converter.convertToComment(comment));
    }

    @Override
    public void deleteById(Integer id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<CommentDTO> getAll() {
        return commentRepository.findAll().stream()
                .map(c -> converter.convertToCommentDto(c))
                .collect(Collectors.toList());
    }
}
