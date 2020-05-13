package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw.dto.CommentDTO;
import ru.otus.hw.jpa.repository.CommentRepository;
import ru.otus.hw.utils.DtoJpaConverter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
@Service
@RequiredArgsConstructor
public class CommentProviderImpl implements CommentProvider {
    private final CommentRepository commentRepository;
    private final DtoJpaConverter converter;

    @Override
    public List<CommentDTO> getByBookId(Integer bookId) {
        return commentRepository.findByBookId(bookId)
                .stream()
                .map(c -> converter.convertToCommentDto(c))
                .collect(Collectors.toList());
    }
}
