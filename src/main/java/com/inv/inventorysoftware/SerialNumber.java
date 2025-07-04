package com.inv.inventorysoftware;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class SerialNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tell;s springboot and jpa to automatically generate a unique number for the id field when saving a new obj to the DB
    // ^ pretty important i would say!

    private Long id;

    private String serial;

    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;

    @ManyToOne // declares the many to one assignment
    @JoinColumn(name = "item_id") // This tells the database: " Create a column called item_id in the serial_number table."
    @JsonBackReference
    private Item item;

    public SerialNumber() {}

    // Constructor without status or date
    public SerialNumber(String serial, Item item) {
        this.serial = serial;
        this.item = item;
        this.status = "In Stock"; // Default
        this.dateAdded = new Date(); // Now
    }

    // Constructor with status
    public SerialNumber(String serial, Item item, String status) {
        this.serial = serial;
        this.item = item;
        this.status = status;
        this.dateAdded = new Date(); // Set when created
    }

    public Long getId() {
        return id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}
