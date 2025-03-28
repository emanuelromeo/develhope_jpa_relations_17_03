package com.crud.jpa_relations_17_03.controller.one_to_many;

import com.crud.jpa_relations_17_03.entity.one_to_many.Book;
import com.crud.jpa_relations_17_03.service.one_to_many.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * Saves the given book.
     *
     * @param book
     * @return a response entity containing the saved book.
     */
    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        return ResponseEntity.ok(savedBook);
    }

    /**
     * Selects all books.
     *
     * @return a response entity containing the page of selected books.
     */
    @GetMapping("/select-all")
    public ResponseEntity<List<Book>> selectAllBooks() {

        List<Book> books = bookService.findAllBooks();
        return ResponseEntity.ok(books);

    }

    /**
     * Selects a book by its id.
     *
     * @param id
     * @return a response entity containing the book with the given id or ResponseEntity.notFound() if not found.
     */
    @GetMapping("/select-by-id/{id}")
    public ResponseEntity<Book> selectBookById(@PathVariable Long id) {
        Optional<Book> optionalBook = bookService.findBookById(id);

        if (optionalBook.isPresent()) {
            return ResponseEntity.ok(optionalBook.get());
        }

        return ResponseEntity.notFound().build();
    }

//    /**
//     * Selects all books published after the given publicationDate or written by the given author.
//     *
//     * @param publicationDate
//     * @param author
//     * @return a response entity containing the list of selected books.
//     */
//    @GetMapping("/select-by-publication-date-after-or-author")
//    public ResponseEntity<List<Book>> selectBookByPublicationDateAfterOrAuthor(
//            @RequestParam LocalDate publicationDate,
//            @RequestParam Author author) {
//
//        List<Book> books = bookService.findBooksByPublicationDateAfterOrAuthor(publicationDate, author);
//        return ResponseEntity.ok(books);
//    }

    /**
     * Updates the book with the given id with values from the given updatedOrder.
     *
     * @param id
     * @param updatedBook
     * @return a response entity containing the updated book or ResponseEntity.notFound() if not found.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Optional<Book> optionalBook = bookService.updateBook(id, updatedBook);

        if (optionalBook.isPresent()) {
            return ResponseEntity.ok(optionalBook.get());
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * Soft deletes th book with the given id.
     *
     * @param id
     * @return a response entity containing the deleted book or ResponseEntity.notFound() if none found.
     */
    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Optional<Book> optionalBook = bookService.deleteBookById(id);

        if (optionalBook.isPresent()) {
            return ResponseEntity.ok(optionalBook.get());
        }

        return ResponseEntity.notFound().build();
    }

}
