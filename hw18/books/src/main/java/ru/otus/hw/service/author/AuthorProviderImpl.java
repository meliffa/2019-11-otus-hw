package ru.otus.hw.service.author;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class AuthorProviderImpl implements AuthorProvider {
    private final AuthorRepository authorRepository;
    private final DtoJpaConverter converter;

    @Override
    public void create(AuthorDTO author) {
        authorRepository.save(converter.convertToAuthor(author));
    }


    @Override
    public void update(AuthorDTO author) {
        authorRepository.save(converter.convertToAuthor(author));
    }

    @Override
    public List<AuthorDTO> getAll() {
        return authorRepository.findAll().stream()
                .map(a -> converter.convertToAuthorDto(a))
                .collect(Collectors.toList());
    }
}
