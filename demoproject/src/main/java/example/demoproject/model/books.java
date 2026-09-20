package example.demoproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "books")
public class books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank 
    private String name;

    @ManyToOne
    @JoinColumn (name = "author_id", nullable = false)
    private author authorName;

    @Column(nullable = false)
    private int price;

    public books() {
        System.out.println("hello this is book class");
    }

    public books(String name, author authorName, int price) {
        this.name = name;
        this.authorName = authorName;
        this.price = price;

        System.out.println("book name is " + name);
        System.out.println("book author is " + authorName);
        System.out.println("book price is " + price);
    }

    public void getDetails() {
        System.out.println("This is a book object");
        System.out.println("Book ID: " + this.id);
        System.out.println("Book Name: " + this.name);
        System.out.println("Book Author: " + this.authorName);
        System.out.println("Book Price: " + this.price);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public author getAuthorName() {
        return authorName;
    }

    public void setAuthorName(author authorName) {
        this.authorName = authorName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}