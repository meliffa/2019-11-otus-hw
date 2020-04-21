package ru.otus.hw.service.genre;

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
public class GenreProviderImpl implements GenreProvider {

    private final GenreRepository genreRepository;
    private final DtoJpaConverter converter;

    public GenreProviderImpl(GenreRepository genreRepository, DtoJpaConverter converter) {
        this.genreRepository = genreRepository;
        this.converter = converter;
    }

    @Override
    public void create(GenreDTO genre) {
        genreRepository.save(converter.convertToGenre(genre));
    }

    @Override
    public GenreDTO getById(Integer id) {
        Genre genre = genreRepository.findById(id).orElse(null);
        return genre != null ? converter.convertToGenreDto(genre) : null;
    }

    @Override
    public GenreDTO getByName(String name) {
        Genre genre = genreRepository.findByGenreName(name).orElse(null);
        return genre != null ? converter.convertToGenreDto(genre) : null;
    }

    @Override
    public GenreDTO getOrCreateByName(String name) {
        if (genreRepository.findByGenreName(name) == null) genreRepository.save(
                converter.convertToGenre(GenreDTO.builder()
                        .genreName(name)
                        .build()
                )
        );
        Genre genre = genreRepository.findByGenreName(name).orElse(null);
        return genre != null ? converter.convertToGenreDto(genre) : null;
    }

    @Override
    public void update(GenreDTO genre) {
        genreRepository.save(converter.convertToGenre(genre));
    }

    @Override
    public void deleteById(Integer id) {
        genreRepository.deleteById(id);
    }

    @Override
    public List<GenreDTO> getAll() {
        return genreRepository.findAll().stream()
                .map(g -> converter.convertToGenreDto(g))
                .collect(Collectors.toList());
    }
}
