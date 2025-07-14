package com.inv.inventorysoftware;

// Annotating Item to be a JPA entity essentially means that you are telling Spring Boot that Item
// is something you want to save in a DB. JPA is a set of tools & rules that help store & retrieve Java objects (like Item) from a DB
// so you dont have to write SQL manually, JPA takes care of it.

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity; // Step 1: import this so Spring knows this class is a DB entity

import jakarta.persistence.Id; // Step 2: import this to tell Spring what the primary key is
// recall that primary keys are a special column in DBs that uniquely identify each row as no 2 rows can have the same values
// in this column
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
@Entity // Tells spring THIS class should be stored in the DB
public class Item {

    @Id // Tells spring this is the unique ID for each Item row in the table
    private String id;
    private String name;
    private int quantity;

    private String model;
    private String comment;
    @Column(length = 1000) // <-- makes the url space longer
    private String imageUrl;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SerialNumber> serialNumbers = new ArrayList<>();

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    public List<SerialNumber> getSerialNumbers() {
        return serialNumbers;
    }
    
    public void setSerialNumbers(List<SerialNumber> serialNumbers) {
        this.serialNumbers = serialNumbers;
    }

    // default constructor
    public Item(){

    }

    // constructor in use
    public Item(String name, String id, int quantity, String model, String comment, String imageUrl) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.model = model;
        this.comment = comment;
        this.imageUrl = imageUrl;
    }

    // --- getters ---
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    // --- setters ---
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getModel() {
        return model;
    }

    // additional getters & setters i created
    public void setModel(String model) {
        this.model = model;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
