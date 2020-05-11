package ru.otus.hw.utils;

import org.springframework.stereotype.Service;
import ru.otus.hw.dto.AuthorDTO;
import ru.otus.hw.dto.BookDTO;
import ru.otus.hw.dto.GenreDTO;
import ru.otus.hw.jpa.entity.Author;
import ru.otus.hw.jpa.entity.Book;
import ru.otus.hw.jpa.entity.Genre;

/**
 * Created by Inna Spodarik on 05.03.2020.
 */
@Service
public class DtoJpaConverter {

    public Author convertToAuthor(AuthorDTO author) {
        return Author.builder()
                .authorId(author.getAuthorId())
                .authorName(author.getAuthorName())
                .build();
    }

    public Genre convertToGenre(GenreDTO genre) {
        return Genre.builder()
                .genreId(genre.getGenreId())
                .genreName(genre.getGenreName())
                .build();
    }

    public Book convertToBook(BookDTO book) {
        return Book.builder()
                .bookId(book.getBookId())
                .bookName(book.getBookName())
                .authorId(book.getAuthor().getAuthorId())
                .genreId(book.getGenre().getGenreId())
                .build();
    }

    public AuthorDTO convertToAuthorDto(Author author) {
        return AuthorDTO.builder()
                .authorId(author.getAuthorId())
                .authorName(author.getAuthorName())
                .build();
    }

    public GenreDTO convertToGenreDto(Genre genre) {
        return GenreDTO.builder()
                .genreId(genre.getGenreId())
                .genreName(genre.getGenreName())
                .build();
    }

    public BookDTO convertToBookDto(Book book) {
        return BookDTO.builder()
                .bookId(book.getBookId())
                .bookName(book.getBookName())
                .author(convertToAuthorDto(book.getAuthor()))
                .genre(convertToGenreDto(book.getGenre()))
                .build();
    }
}
