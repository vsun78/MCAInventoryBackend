/*
package com.inv.inventorysoftware;


// Annotating Item to be a JPA entity essentially means that you are telling Spring Boot that Item
// is something you want to save in a DB. JPA is a set of tools & rules that help store & retrieve Java objects (like Item) from a DB
// so you don't have to write SQL manually, JPA takes care of it.

import jakarta.persistence.*;

@Entity // Tells Spring THIS class should be stored in the DB
public class Item {

    @Id // Tells Spring this is the unique ID for each Item row in the table
    private String id;

    private String name;
    private int quantity;
    private String model;
    private String comment;

    @Column(length = 1000) // <-- makes the url space longer
    private String imageUrl;

    // Default constructor
    public Item() {
    }

    // Constructor without id — Spring will auto-generate it
    public Item(String name, String id, int quantity, String model, String comment, String imageUrl) {
        this.name = name;
        this.quantity = quantity;
        this.id = id;
        this.model = model;
        this.comment = comment;
        this.imageUrl = imageUrl;
    }

    // --- Getters ---
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getModel() {
        return model;
    }

    public String getComment() {
        return comment;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    // --- Setters ---
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

-- old --
 */

package com.inv.inventorysoftware;

// Annotating Item to be a JPA entity essentially means that you are telling Spring Boot that Item
// is something you want to save in a DB. JPA is a set of tools & rules that help store & retrieve Java objects (like Item) from a DB
// so you dont have to write SQL manually, JPA takes care of it.

import jakarta.persistence.Entity; // Step 1: import this so Spring knows this class is a DB entity

import jakarta.persistence.Id; // Step 2: import this to tell Spring what the primary key is
// recall that primary keys are a special column in DBs that uniquely identify each row as no 2 rows can have the same values
// in this column

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
