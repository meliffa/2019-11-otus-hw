package ru.otus.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.hw.jpa.entity.Book;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Data
@Builder
@AllArgsConstructor
public class BookDTO {
    private Integer bookId;
    private String bookName;
    private AuthorDTO author;
    private GenreDTO genre;

    public Book buildJpaEntity() {
        return Book.builder()
                .bookId(bookId)
                .bookName(bookName)
                .authorId(author.getAuthorId())
                .genreId(genre.getGenreId())
                .build();
    }

    @Override
    public String toString() {
        return "BookDTO {" +
                "\n bookId = " + bookId +
                ",\n bookName = " + bookName +
                ",\n author = " + author.getAuthorName() +
                ",\n genre = " + genre.getGenreName() +
                "\n}";
    }
}
