package ru.otus.hw.db.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inna Spodarik on 24.02.2020.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "books")
@Data
public class Book {
    @Transient
    public static final String SEQUENCE = "booksSeq";

    @Id
    private Integer bookId;

    @Field("bookName")
    private String bookName;

    @DBRef
    private Author author;

    @DBRef
    private Genre genre;

    @DBRef
    private List<Comment> comments = new ArrayList<>();

}
