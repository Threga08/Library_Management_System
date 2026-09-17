package example.demoproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import example.demoproject.model.author;
import example.demoproject.repository.authorRepository;

@Service
public class authorService {

    private final authorRepository repository;

    public authorService(authorRepository repository) {
        this.repository = repository;
    }

    // Get all authors
    public List<author> getAllAuthors() {
        return repository.findAll();
    }

    // Get author by ID
    public author getAuthorById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Author not found with id: " + id));
    }

    // Save new author
    public author saveAuthor(author author) {
        return repository.save(author);
    }

    // Delete author
    public void deleteAuthor(Long id) {
        repository.deleteById(id);
    }

    // Update author
    public author updateAuthor(Long id, author updatedAuthor) {

        return repository.findById(id)
                .map(existingAuthor -> {

                    existingAuthor.setName(updatedAuthor.getName());
                    existingAuthor.setNationality(updatedAuthor.getNationality());

                    return repository.save(existingAuthor);
                })
                .orElseThrow(() ->
                    new RuntimeException("Author not found with id: " + id));
    }
}