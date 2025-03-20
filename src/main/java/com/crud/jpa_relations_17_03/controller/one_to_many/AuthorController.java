package com.crud.jpa_relations_17_03.controller.one_to_many;

import com.crud.jpa_relations_17_03.entity.one_to_many.Author;
import com.crud.jpa_relations_17_03.service.one_to_many.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    /**
     * Saves the given author.
     *
     * @param author
     * @return a response entity containing the saved author.
     */
    @PostMapping("/create")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {

        Author savedAuthor = authorService.saveAuthor(author);
        return ResponseEntity.ok(savedAuthor);

    }

    /**
     * Selects all authors.
     *
     * @return a response entity containing the page of selected authors.
     */
    @GetMapping("/select-all")
    public ResponseEntity<List<Author>> selectAllAuthors() {

        List<Author> authors = authorService.findAllAuthors();
        return ResponseEntity.ok(authors);

    }
}
