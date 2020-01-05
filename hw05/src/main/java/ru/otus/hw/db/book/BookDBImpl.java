package ru.otus.hw.db.book;

import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.hw.entity.Book;
import ru.otus.hw.utils.db.BookRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Repository
public class BookDBImpl implements BookDBProvider {
    private final NamedParameterJdbcTemplate template;

    public BookDBImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Book getBookById(Integer bookId) {
        String query="select b.bookid, b.bookname, b.authorid, b.genreid, a.authorname, g.genrename " +
                "from hw_book b " +
                "left join hw_author a on b.authorid = a.authorid " +
                "left join hw_genre g on b.genreid = g.genreid " +
                "where bookid = :bookId";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("bookId", bookId);
        List<Book> books = template.query(query, queryParams, new BookRowMapper());
        if (books.size() > 0) return books.get(0); else return null;
    }

    @Override
    public Book getBookByName(String bookName) {
        String query="select b.bookid, b.bookname, b.authorid, b.genreid, a.authorname, g.genrename " +
                "from hw_book b " +
                "left join hw_author a on b.authorid = a.authorid " +
                "left join hw_genre g on b.genreid = g.genreid " +
                "where upper(b.bookname) = :bookName";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("bookName", bookName.toUpperCase());
        List<Book> books = template.query(query, queryParams, new BookRowMapper());
        if (books.size() > 0) return books.get(0); else return null;
    }

    @Override
    public void insertBook(Book book) {
        String query="insert into hw_book(bookname, authorid, genreid) values (:bookName, :authorId, :genreId)";
        template.execute(query, book.convertToMap(), (PreparedStatementCallback) ps -> ps.executeUpdate());
    }

    @Override
    public void deleteBookById(Integer bookId) {
        String query="delete from hw_book where bookId = :bookId)";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("bookId", bookId);
        template.execute(query, queryParams, (PreparedStatementCallback) ps -> ps.executeUpdate());
    }

    @Override
    public List<Book> getAllBooks() {
        String query="select b.bookid, b.bookname, b.authorid, b.genreid, a.authorname, g.genrename " +
                "from hw_book b " +
                "left join hw_author a on b.authorid = a.authorid " +
                "left join hw_genre g on b.genreid = g.genreid";
        return template.query(query, new BookRowMapper());
    }

    @Override
    public void updateBookAuthor(Integer bookId, Integer authorId) {
        String query="update hw_book set authorid = :authorId where bookid = :bookId";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("bookId", bookId);
        queryParams.put("authorId", authorId);
        template.execute(query, queryParams, (PreparedStatementCallback) ps -> ps.executeUpdate());
    }

    @Override
    public void updateBookGenre(Integer bookId, Integer genreId) {
        String query="update hw_book set genreid = :genreId where bookid = :bookId";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("bookId", bookId);
        queryParams.put("genreId", genreId);
        template.execute(query, queryParams, (PreparedStatementCallback) ps -> ps.executeUpdate());
    }

    @Override
    public void updateBookName(Integer bookId, String bookName) {
        String query="update hw_book set bookname = :bookName where bookid = :bookId";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("bookId", bookId);
        queryParams.put("bookName", bookName);
        template.execute(query, queryParams, (PreparedStatementCallback) ps -> ps.executeUpdate());
    }
}
