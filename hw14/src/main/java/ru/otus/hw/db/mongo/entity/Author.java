package ru.otus.hw.db.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by Inna Spodarik on 24.02.2020.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "authors")
@Data
public class Author {
    @Transient
    public static final String SEQUENCE = "authorsSeq";

    @Id
    private Integer authorId;

    @Field("authorName")
    private String authorName;

    @Override
    public String toString() {
        return authorName;
    }

    @Override
    public boolean equals(Object author) {
        return this.authorId.equals(((Author) author).getAuthorId());
    }

}
