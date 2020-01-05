package ru.otus.hw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre {
    private Integer genreId;
    private String genreName;

    public Genre(String genreName) {
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
}
