package com.crud.jpa_relations_17_03.service.one_to_many;

import com.crud.jpa_relations_17_03.entity.one_to_many.Author;
import com.crud.jpa_relations_17_03.repository.one_to_many.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    /**
     * Saves the given author.
     *
     * @param author
     * @return the saved author.
     */
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    /**
     * Selects all authors.
     *
     * @return the page of selected authors.
     */
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }
}
