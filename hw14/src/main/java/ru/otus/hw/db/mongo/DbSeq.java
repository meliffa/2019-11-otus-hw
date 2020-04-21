package ru.otus.hw.db.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Inna Spodarik on 21.04.2020.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "dbSeq")
public class DbSeq {
    @Id
    private String id;

    private Integer seq;
}
