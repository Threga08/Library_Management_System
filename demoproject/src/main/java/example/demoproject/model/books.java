package example.demoproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private int price;

    public books() {
        System.out.println("hello this is book class");
    }

    public books(String name, String author, int price) {
        this.name = name;
        this.author = author;
        this.price = price;

        System.out.println("book name is " + name);
        System.out.println("book author is " + author);
        System.out.println("book price is " + price);
    }

    public void getDetails() {
        System.out.println("This is a book object");
        System.out.println("Book ID: " + this.id);
        System.out.println("Book Name: " + this.name);
        System.out.println("Book Author: " + this.author);
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}