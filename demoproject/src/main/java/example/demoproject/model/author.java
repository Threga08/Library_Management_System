package example.demoproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nationality;

    public author() {
        System.out.println("hello this is author class");
    }
    
    public author(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public void getDetails() {
        System.out.println("This is an author object");
        System.out.println("Author ID: " + this.authorId);
        System.out.println("Author Name: " + this.name);
        System.out.println("Author Nationality: " + this.nationality);
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}