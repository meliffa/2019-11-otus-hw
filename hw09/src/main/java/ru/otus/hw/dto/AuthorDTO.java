package ru.otus.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.hw.jpa.entity.Author;
import java.util.Set;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
    private Integer authorId;
    private String authorName;
    private Set<BookDTO> books;

    @Override
    public String toString() {
        return "AuthorDTO {" +
                "\n authorId = " + authorId +
                ",\n authorName = " + authorName +
                "\n}";
    }
}
