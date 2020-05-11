package ru.otus.hw.utils;

import org.springframework.stereotype.Service;
import ru.otus.hw.dto.CommentDTO;
import ru.otus.hw.jpa.entity.Comment;

/**
 * Created by Inna Spodarik on 05.03.2020.
 */
@Service
public class DtoJpaConverter {
    public Comment convertToComment(CommentDTO comment) {
        return Comment.builder()
                .commentId(comment.getCommentId())
                .bookId(comment.getBookId())
                .comment(comment.getComment())
                .build();
    }

    public CommentDTO convertToCommentDto(Comment comment) {
        return CommentDTO.builder()
                .commentId(comment.getCommentId())
                .comment(comment.getComment())
                .bookId(comment.getBookId())
                .build();
    }
}
