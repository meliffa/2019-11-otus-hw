package ru.otus.hw.db.author;

import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.hw.entity.Author;
import ru.otus.hw.utils.db.AuthorRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Repository
public class AuthorDBImpl implements AuthorDBProvider {

    private final NamedParameterJdbcTemplate template;

    public AuthorDBImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Author getExistingAuthorById(Integer authorId) {
        String query="select * from hw_author where authorid = :authorId";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("authorId", authorId);
        return template.queryForObject(query, queryParams, new AuthorRowMapper());
    }

    @Override
    public Author getAuthorByName(String authorName) {
        String query="select * from hw_author where upper(authorname) = :authorName";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("authorName", authorName.toUpperCase());
        List<Author> authors = template.query(query, queryParams, new AuthorRowMapper());
        if (authors.size() > 0) return authors.get(0); else return null;
    }

    @Override
    public void insertAuthor(Author author) {
        String query="insert into hw_author(authorname) values (:authorName)";
        template.execute(query, author.convertToMap(), (PreparedStatementCallback) ps -> ps.executeUpdate());
    }
}
