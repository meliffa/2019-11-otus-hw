package ru.otus.hw.utils.db;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.hw.dto.AuthorDTO;
import ru.otus.hw.dto.BookDTO;
import ru.otus.hw.dto.GenreDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public class BookRowMapper implements RowMapper<BookDTO> {
    @Override
    public BookDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        BookDTO book = new BookDTO();
        book.setBookId(rs.getInt("bookid"));
        book.setBookName(rs.getString("bookname"));
        book.setAuthor(new AuthorDTO(rs.getInt("authorid"), rs.getString("authorname")));
        book.setGenre(new GenreDTO(rs.getInt("genreid"), rs.getString("genrename")));
        return book;
    }
}