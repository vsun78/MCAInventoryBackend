/*
package com.inv.inventorysoftware;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "users") // this is to assign a name to the table so theres no keyword conflict with "User" (hence why item.java didnt need this line)
public class User {

    @Id
    @Column(nullable = false, unique = true) // this is added to add filters to username creation. It now cannot be empty nor the same as another users
    private String username;
    //private String password;
    // Alright so plain text passwords are stupid, i will change it to Bcrypt
    @Column(nullable = false)
    private String password;

    //Spring Boot needs a default constructor to run
    public User()
    {

    }
    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }


}
*/


package com.inv.inventorysoftware;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
