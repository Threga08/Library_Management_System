package example.demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import example.demoproject.model.books;

public interface booksRepository extends JpaRepository<books, Long> {
}
