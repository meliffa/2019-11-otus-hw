package ru.otus.hw.service.book;

import ru.otus.hw.dto.BookDTO;
import java.util.List;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public interface BookProvider {
    void create(BookDTO book);
    BookDTO getById(Integer id);
    List<BookDTO> getByName(String name);
    void update(BookDTO book);
    void deleteById(Integer id);
    List<BookDTO> getAll();
}
