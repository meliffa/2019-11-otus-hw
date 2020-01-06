package ru.otus.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.hw.jpa.entity.Genre;

import java.util.HashMap;
import java.util.Map;

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

    public GenreDTO(String genreName) {
        this.genreName = genreName;
    }

    public Map convertToMap() {
        Map genreMap = new HashMap<>();
        if (genreId != null) {
            genreMap.put("genreId", genreId);
        }
        genreMap.put("genreName", genreName);
        return genreMap;
    }

    public Genre buildJpaEntity() {
        return Genre.builder()
                .genreId(genreId)
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
