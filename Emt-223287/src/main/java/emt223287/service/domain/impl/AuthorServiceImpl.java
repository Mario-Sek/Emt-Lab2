package emt223287.service.domain.impl;



import emt223287.model.domain.Author;
import emt223287.model.domain.Country;
import emt223287.repository.AuthorRepository;
import emt223287.service.domain.AuthorService;
import emt223287.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryService countryService;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryService countryService) {
        this.authorRepository = authorRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author addAuthor(Author author) {
        Author a = new Author();
        return saveAuthor(author, a);
    }

    @Override
    public Author editAuthor(Long id, Author author) {
        Author a = authorRepository.findById(id).orElse(null);

        if (a == null) {
            return null;
        }

        return saveAuthor(author, a);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    private Author saveAuthor(Author author, Author a) {
        Country c = countryService.getCountryById(author.getCountry().getId());

        if (c == null) {
            return null;
        }

        a.setName(author.getName());
        a.setSurname(author.getSurname());
        a.setCountry(c);

        return authorRepository.save(a);
    }


}

