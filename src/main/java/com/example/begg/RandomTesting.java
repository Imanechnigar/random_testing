package com.example.begg;

import jakarta.persistence.*;

@Entity
@Table(name = "random_testing")
public class RandomTesting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;


    public RandomTesting(Integer id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public RandomTesting() {

    }

    // getters
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    // setters
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account Information:\n" +
                "Client ID: " + id + "\n" +
                "Client name: " + name + "\n" +
                "Client email: " + email + "\n" +
                "Client password: " + password;
    }


}
