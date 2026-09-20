package example.demoproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import example.demoproject.model.author;
import example.demoproject.model.books;
import example.demoproject.repository.booksRepository;

@Service
public class bookService {
    private final booksRepository repository;

    public bookService(booksRepository repository) {
        this.repository = repository;
    }

    public books getbook() {
        return new books("The Great Gatsby", new author("F. Scott Fitzgerald", "American"), 100);
    }

    public books addbook(String name, author authorName, int price) {
        return new books(name, authorName, price);
    }

    public List<books> getAllBooks() {
        return repository.findAll();
    }

    public books getbookById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    public books saveBook(books book) {
        return repository.save(book);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
    public books updateBook(Long id, books updatedBook) {
        return repository.findById(id)
                .map(book -> {
                    book.setName(updatedBook.getName());
                    book.setAuthorName(updatedBook.getAuthorName());
                    book.setPrice(updatedBook.getPrice());
                    return repository.save(book);
                })
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }
}

