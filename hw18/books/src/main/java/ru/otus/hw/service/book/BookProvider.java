package ru.otus.hw.service.book;

import ru.otus.hw.dto.BookDTO;
import java.util.List;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public interface BookProvider {
    void deleteById(Integer id);
    List<BookDTO> getAll();
    BookDTO getById(Integer id);
    List<BookDTO> getByAuthorId(Integer authorId);
}
