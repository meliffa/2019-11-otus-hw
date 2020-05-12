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
@Document(collection = "comments")
@Data
public class Comment {
    @Id
    private String commentId;

    @Field("comment")
    private String comment;

    public Comment(String comment) {
        this.commentId = UUID.randomUUID().toString();
        this.comment = comment;
    }
}
