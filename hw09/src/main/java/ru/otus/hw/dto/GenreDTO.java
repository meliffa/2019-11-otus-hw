package ru.otus.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.hw.jpa.entity.Genre;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO {
    private Integer genreId;
    private String genreName;

    @Override
    public String toString() {
        return "GenreDTO {" +
                "\n genreId = " + genreId +
                ",\n genreName = " + genreName +
                "\n}";
    }
}
