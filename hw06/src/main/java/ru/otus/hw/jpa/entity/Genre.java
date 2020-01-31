package ru.otus.hw.jpa.entity;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import ru.otus.hw.dto.GenreDTO;

import javax.persistence.*;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="HW_GENRE")
public class Genre {
    @Id
    @Column(name = "GENREID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genreId;

    @Column(name = "GENRENAME")
    private String genreName;

    public GenreDTO buildDTO() {
        return GenreDTO.builder()
                .genreId(genreId)
                .genreName(genreName)
                .build();
    }
}
