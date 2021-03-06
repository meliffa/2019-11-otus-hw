package ru.otus.hw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer bookId;
    private String bookName;
    private Author author;
    private Genre genre;

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Map convertToMap() {
        Map bookMap = new HashMap<>();
        if (bookId != null) {
            bookMap.put("bookId", bookId);
        }
        bookMap.put("bookName", bookName);
        bookMap.put("authorId", author.getAuthorId());
        bookMap.put("genreId", genre.getGenreId());
        return bookMap;
    }
}
