package emt223287.service.domain.impl;

import emt223287.model.domain.Author;
import emt223287.model.domain.Book;
import emt223287.repository.BookRepository;
import emt223287.service.domain.AuthorService;
import emt223287.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book addBook(Book book) {
        Book b = new Book();
        return saveBook(book, b);
    }

    @Override
    public Book editBook(Long id, Book book) {
        Book b = bookRepository.findById(id).orElse(null);

        if (b == null) {
            return null;
        }

        return saveBook(book, b);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void markBookAsTaken(Long id) {
        Book b = bookRepository.findById(id).orElse(null);

        if (b == null) {
            return;
        }

        b.setAvailableCopies(b.getAvailableCopies() == 0 ? 0 : b.getAvailableCopies() - 1);

        bookRepository.save(b);
    }


    private Book saveBook(Book book, Book b) {
        Author a = authorService.getAuthorById(book.getAuthor().getId());

        if (a == null) {
            return null;
        }

        b.setName(book.getName().isEmpty() ? "Unnamed Book" : book.getName());
        b.setCategory(book.getCategory());
        b.setAuthor(a);
        b.setAvailableCopies(book.getAvailableCopies() >= 0 ? book.getAvailableCopies() : 0);

        return bookRepository.save(b);
    }
}
