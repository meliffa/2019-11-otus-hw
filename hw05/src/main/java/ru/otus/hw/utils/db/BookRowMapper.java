package ru.otus.hw.utils.db;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.hw.entity.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBookId(rs.getInt("bookid"));
        book.setBookName(rs.getString("bookname"));
        book.setAuthorId(rs.getInt("authorid"));
        book.setAuthor(rs.getString("authorname"));
        book.setGenreId(rs.getInt("genreid"));
        book.setGenre(rs.getString("genrename"));
        return book;
    }
}