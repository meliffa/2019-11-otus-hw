package ru.otus.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.otus.hw.db.entity.Book;

import java.util.UUID;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Data
@Builder
@AllArgsConstructor
public class BookDTO {
    private String bookId;
    private String bookName;
    private AuthorDTO author;
    private GenreDTO genre;

    public Book buildDBEntity() {
        return Book.builder()
                .bookId(bookId != null ? bookId : UUID.randomUUID().toString())
                .bookName(bookName)
                .author(author.buildDBEntity())
                .genre(genre.buildDBEntity())
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
