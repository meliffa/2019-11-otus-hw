package ru.otus.hw.db.genre;

import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.hw.entity.Genre;
import ru.otus.hw.utils.db.GenreRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Repository
public class GenreDBImpl implements GenreDBProvider {

    private final NamedParameterJdbcTemplate template;

    public GenreDBImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Genre getExistingGenreById(Integer genreId) {
        String query="select * from hw_genre where genreid = :genreId";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("genreId", genreId);
        return template.queryForObject(query, queryParams, new GenreRowMapper());
    }

    @Override
    public Genre getGenreByName(String genreName) {
        String query="select * from hw_genre where upper(genrename) = :genreName";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("genreName", genreName.toUpperCase());
        List<Genre> genres = template.query(query, queryParams, new GenreRowMapper());
        if (genres.size() > 0) return genres.get(0); else return null;
    }

    @Override
    public void insertGenre(Genre genre) {
        String query="insert into hw_genre(genrename) values (:genreName)";
        template.execute(query, genre.convertToMap(), (PreparedStatementCallback) ps -> ps.executeUpdate());
    }
}
