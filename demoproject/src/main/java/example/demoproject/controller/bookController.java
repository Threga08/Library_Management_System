package example.demoproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.demoproject.model.books;
import example.demoproject.service.bookService;

@RestController
@RequestMapping("/books")
public class bookController {

    private final bookService service;

    public bookController(bookService service) {
        this.service = service;
    }

    // GET all books
    @GetMapping
    public List<books> getAllBooks() {
        return service.getAllBooks();
    }

    // GET book by ID
    @GetMapping("/{id}")
    public books getBookById(@PathVariable Long id) {
        return service.getbookById(id);
    }

    // POST - create a new book
    @PostMapping
    public books createBook(@RequestBody books book) {
        return service.saveBook(book);
    }

    // PUT - update an existing book
    @PutMapping("/{id}")
    public books updateBook(
            @PathVariable Long id,
            @RequestBody books updatedBook) {

        return service.updateBook(id, updatedBook);
    }

    // DELETE - delete a book
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
    }
}