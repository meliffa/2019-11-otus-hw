package ru.otus.hw.service.author;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.dto.AuthorDTO;
import ru.otus.hw.jpa.entity.Author;
import ru.otus.hw.jpa.repository.author.AuthorRepository;
import ru.otus.hw.utils.DtoJpaConverter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Service
public class AuthorProviderImpl implements AuthorProvider {
    private final AuthorRepository authorRepository;
    private final DtoJpaConverter converter;

    public AuthorProviderImpl(AuthorRepository authorRepository, DtoJpaConverter converter) {
        this.authorRepository = authorRepository;
        this.converter = converter;
    }

    @Override
    public void create(AuthorDTO author) {
        authorRepository.save(converter.convertToAuthor(author));
    }

    @Override
    public AuthorDTO getById(Integer id) {
        Author author = authorRepository.findById(id).orElse(null);
        return author != null ? converter.convertToAuthorDto(author) : null;
    }

    @Override
    public AuthorDTO getByName(String name) {
        Author author = authorRepository.findByAuthorName(name).orElse(null);
        return author != null ? converter.convertToAuthorDto(author) : null;
    }

    @Override
    @Transactional
    public AuthorDTO getByNameWithBooks(String name) {
        Author author = authorRepository.findByAuthorName(name != null ? name.toUpperCase() : null).orElse(null);
        AuthorDTO authorDTO = null;
        if (author != null) {
            authorDTO = converter.convertToAuthorDto(author);
            authorDTO.setBooks(
                    author.getBooks().stream()
                            .map(b -> converter.convertToBookDto(b))
                            .collect(Collectors.toSet())
            );
        }
        return authorDTO;
    }

    @Override
    public AuthorDTO getOrCreateByName(String name) {
        if (authorRepository.findByAuthorName(name) == null) authorRepository.save(
                converter.convertToAuthor(AuthorDTO.builder()
                        .authorName(name)
                        .build()
                )
        );
        Author author = authorRepository.findByAuthorName(name).orElse(null);
        return author != null ? converter.convertToAuthorDto(author) : null;
    }

    @Override
    public void update(AuthorDTO author) {
        authorRepository.save(converter.convertToAuthor(author));
    }

    @Override
    public void deleteById(Integer id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<AuthorDTO> getAll() {
        return authorRepository.findAll().stream()
                .map(a -> converter.convertToAuthorDto(a))
                .collect(Collectors.toList());
    }
}
