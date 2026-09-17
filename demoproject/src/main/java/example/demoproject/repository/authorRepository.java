package example.demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import example.demoproject.model.author;

public interface authorRepository extends JpaRepository<author, Long> {

}