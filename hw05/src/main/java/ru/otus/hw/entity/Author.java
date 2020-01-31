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
public class Author {
    private Integer authorId;
    private String authorName;

    public Author(String authorName) {
        this.authorName = authorName;
    }

    public Map convertToMap() {
        Map authorMap = new HashMap<>();
        if (authorId != null) {
            authorMap.put("authorId", authorId);
        }
        authorMap.put("authorName", authorName);
        return authorMap;
    }
}
