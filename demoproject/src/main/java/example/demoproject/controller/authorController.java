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

import example.demoproject.model.author;
import example.demoproject.service.authorService;

@RestController
@RequestMapping("/authors")
public class authorController {

    private final authorService service;

    public authorController(authorService service) {
        this.service = service;
    }

    // GET all authors
    @GetMapping
    public List<author> getAllAuthors() {
        return service.getAllAuthors();
    }

    // GET author by ID
    @GetMapping("/{id}")
    public author getAuthorById(@PathVariable Long id) {
        return service.getAuthorById(id);
    }

    // POST - create a new author
    @PostMapping
    public author createAuthor(@RequestBody author author) {
        return service.saveAuthor(author);
    }

    // PUT - update an existing author
    @PutMapping("/{id}")
    public author updateAuthor(
            @PathVariable Long id,
            @RequestBody author updatedAuthor) {

        return service.updateAuthor(id, updatedAuthor);
    }

    // DELETE - delete an author
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        service.deleteAuthor(id);
    }
}