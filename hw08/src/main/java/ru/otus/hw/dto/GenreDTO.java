package ru.otus.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.otus.hw.db.entity.Genre;

import java.util.UUID;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Data
@Builder
@AllArgsConstructor
public class GenreDTO {
    private String genreId;
    private String genreName;

    public Genre buildDBEntity() {
        return Genre.builder()
                .genreId(genreId != null ? genreId : UUID.randomUUID().toString())
                .genreName(genreName)
                .build();
    }

    @Override
    public String toString() {
        return "GenreDTO {" +
                "\n genreId = " + genreId +
                ",\n genreName = " + genreName +
                "\n}";
    }
}
