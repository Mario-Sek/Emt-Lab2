package emt223287.service.domain;

import emt223287.model.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book addBook(Book book);

    Book editBook(Long id, Book book);

    void deleteBook(Long id);

    void markBookAsTaken(Long id);

}
