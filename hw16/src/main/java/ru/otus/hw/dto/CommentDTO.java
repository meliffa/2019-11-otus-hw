package ru.otus.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.hw.jpa.entity.Comment;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
@Data
@Builder
@AllArgsConstructor
public class CommentDTO {
    private Integer commentId;
    private BookDTO book;
    private String comment;

    @Override
    public String toString() {
        return "CommentDTO {" +
                "\n commentId = " + commentId +
                ",\n bookId = " + book.getBookId() +
                ",\n book = " + book.getBookName() +
                ",\n comment = " + comment +
                "\n}";
    }
}
