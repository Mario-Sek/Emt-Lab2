package emt223287.service.application;


import emt223287.dto.CreateBookDto;
import emt223287.dto.DisplayBookDto;

import java.util.List;

public interface BookApplicationService {
    List<DisplayBookDto> getAllBooks();

    DisplayBookDto getBookById(Long id);

    DisplayBookDto addBook(CreateBookDto createBookDto);

    DisplayBookDto editBook(Long id, CreateBookDto createBookDto);

    void deleteBook(Long id);

    void markBookAsTaken(Long id);

}
