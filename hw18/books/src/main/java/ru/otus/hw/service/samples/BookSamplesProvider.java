package ru.otus.hw.service.samples;

import ru.otus.hw.dto.BookDTO;
import java.util.List;

/**
 * Created by Inna Spodarik on 11.05.2020.
 */
public interface BookSamplesProvider {
    List<BookDTO> getBooksSamples();

    BookDTO getBookSample();

    List<BookDTO> getAuthorBooksSamples();
}
