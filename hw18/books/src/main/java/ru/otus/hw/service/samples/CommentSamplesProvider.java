package ru.otus.hw.service.samples;

import ru.otus.hw.dto.CommentDTO;

import java.util.List;

/**
 * Created by Inna Spodarik on 11.05.2020.
 */
public interface CommentSamplesProvider {
    List<CommentDTO> getCommentsSamples(Integer bookId);
}
