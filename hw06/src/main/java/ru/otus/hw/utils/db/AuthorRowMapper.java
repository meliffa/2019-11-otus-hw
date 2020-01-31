package ru.otus.hw.utils.db;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.hw.dto.AuthorDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public class AuthorRowMapper implements RowMapper<AuthorDTO> {
    @Override
    public AuthorDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        AuthorDTO author = new AuthorDTO();
        author.setAuthorId(rs.getInt("authorId"));
        author.setAuthorName(rs.getString("authorName"));
        return author;
    }
}