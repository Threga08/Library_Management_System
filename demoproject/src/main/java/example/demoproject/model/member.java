package example.demoproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "members")
public class member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    public member(String name, String phone) {
        this.name = name;
        this.phone = phone;

        System.out.println("member name is " + name);
        System.out.println("member phone is " + phone);
    }

    public void getDetails() {
        System.out.println("This is a member object");
        System.out.println("Member ID: " + this.id);
        System.out.println("Member Name: " + this.name);
        System.out.println("Member Phone: " + this.phone);
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}