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
@Document(collection = "comments")
@Data
public class Comment {
    @Transient
    public static final String SEQUENCE = "commentsSeq";

    @Id
    private Integer commentId;

    @Field("comment")
    private String comment;
}
