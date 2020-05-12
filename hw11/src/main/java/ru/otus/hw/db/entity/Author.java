package ru.otus.hw.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.UUID;

/**
 * Created by Inna Spodarik on 24.02.2020.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "authors")
@Data
public class Author {
    @Id
    private String authorId;

    @Field("authorName")
    private String authorName;

    public Author(String authorName) {
        this.authorId = UUID.randomUUID().toString();
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return authorName;
    }

    @Override
    public boolean equals(Object author) {
        return this.authorId.equals(((Author) author).getAuthorId());
    }
}
