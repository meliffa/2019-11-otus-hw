package ru.otus.hw.service.author;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.dto.AuthorDTO;
import ru.otus.hw.jpa.entity.Author;
import ru.otus.hw.jpa.repository.author.AuthorRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Service
public class AuthorImpl implements AuthorProvider {
    private final AuthorRepository authorRepository;

    public AuthorImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void create(AuthorDTO author) {
        authorRepository.insert(author.buildJpaEntity());
    }

    @Override
    public AuthorDTO getById(Integer id) {
        Author author = authorRepository.getById(id);
        return author != null ? author.buildDTO() : null;
    }

    @Override
    public AuthorDTO getByName(String name) {
        Author author = authorRepository.getByName(name);
        return author != null ? author.buildDTO() : null;
    }

    @Override
    @Transactional
    public AuthorDTO getByNameWithBooks(String name) {
        Author author = authorRepository.getByName(name != null ? name.toUpperCase() : null);
        AuthorDTO authorDTO = null;
        if (author != null) {
            authorDTO = author.buildDTO();
            authorDTO.setBooks(
                    author.getBooks().stream()
                            .map(b -> b.buildDTO())
                            .collect(Collectors.toSet())
            );
        }
        return authorDTO;
    }

    @Override
    public AuthorDTO getOrCreateByName(String name) {
        if (authorRepository.getByName(name) == null) authorRepository.insert((new AuthorDTO(name)).buildJpaEntity());
        return authorRepository.getByName(name).buildDTO();
    }

    @Override
    public void update(AuthorDTO author) {
        authorRepository.update(author.buildJpaEntity());
    }

    @Override
    public void deleteById(Integer id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<AuthorDTO> getAll() {
        return authorRepository.getAll().stream()
                .map(a -> a.buildDTO())
                .collect(Collectors.toList());
    }
}
