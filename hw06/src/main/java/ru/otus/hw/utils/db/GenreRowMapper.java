package ru.otus.hw.utils.db;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.hw.dto.GenreDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public class GenreRowMapper implements RowMapper<GenreDTO> {
    @Override
    public GenreDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        GenreDTO genre = new GenreDTO();
        genre.setGenreId(rs.getInt("genreId"));
        genre.setGenreName(rs.getString("genreName"));
        return genre;
    }
}
