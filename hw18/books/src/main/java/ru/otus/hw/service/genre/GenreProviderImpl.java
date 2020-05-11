package ru.otus.hw.service.genre;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw.dto.GenreDTO;
import ru.otus.hw.jpa.entity.Genre;
import ru.otus.hw.jpa.repository.genre.GenreRepository;
import ru.otus.hw.utils.DtoJpaConverter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Service
@RequiredArgsConstructor
public class GenreProviderImpl implements GenreProvider {

    private final GenreRepository genreRepository;
    private final DtoJpaConverter converter;

    @Override
    public void create(GenreDTO genre) {
        genreRepository.save(converter.convertToGenre(genre));
    }

    @Override
    public void update(GenreDTO genre) {
        genreRepository.save(converter.convertToGenre(genre));
    }

    @Override
    public List<GenreDTO> getAll() {
        return genreRepository.findAll().stream()
                .map(g -> converter.convertToGenreDto(g))
                .collect(Collectors.toList());
    }
}
