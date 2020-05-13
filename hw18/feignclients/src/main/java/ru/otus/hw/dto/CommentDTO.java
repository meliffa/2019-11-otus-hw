package ru.otus.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Integer commentId;
    private Integer bookId;
    private String comment;

    @Override
    public String toString() {
        return "CommentDTO {" +
                "\n commentId = " + commentId +
                ",\n bookId = " + bookId +
                ",\n comment = " + comment +
                "\n}";
    }
}
