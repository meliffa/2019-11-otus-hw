package ru.otus.hw.service.genre;

import org.springframework.stereotype.Service;
import ru.otus.hw.dto.GenreDTO;
import ru.otus.hw.jpa.entity.Genre;
import ru.otus.hw.jpa.repository.genre.GenreRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Service
public class GenreImpl implements GenreProvider {

    private final GenreRepository genreRepository;

    public GenreImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public void create(GenreDTO genre) {
        genreRepository.insert(genre.buildJpaEntity());
    }

    @Override
    public GenreDTO getById(Integer id) {
        Genre genre = genreRepository.getById(id);
        return genre != null ? genre.buildDTO() : null;
    }

    @Override
    public GenreDTO getByName(String name) {
        Genre genre = genreRepository.getByName(name);
        return genre != null ? genre.buildDTO() : null;
    }

    @Override
    public GenreDTO getOrCreateByName(String name) {
        if (genreRepository.getByName(name) == null) genreRepository.insert((new GenreDTO(name)).buildJpaEntity());
        return genreRepository.getByName(name).buildDTO();
    }

    @Override
    public void update(GenreDTO author) {
        genreRepository.update(author.buildJpaEntity());
    }

    @Override
    public void deleteById(Integer id) {
        genreRepository.deleteById(id);
    }

    @Override
    public List<GenreDTO> getAll() {
        return genreRepository.getAll().stream()
                .map(g -> g.buildDTO())
                .collect(Collectors.toList());
    }
}
