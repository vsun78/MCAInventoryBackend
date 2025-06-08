package com.inv.inventorysoftware;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
// ^ brings in the JpaRepository inreface from Spring Boot, which gives you ready-made methods to:
// save items to DB, get all items, find one item by ID, delete items, update item info.
// as such, you don;t have to write SQL manually, this import gives you the tools.

public interface ItemRepository extends JpaRepository<Item, String> {

    Optional<Item> findByName(String name); // <-- ADDED THIS LINE B/C ERORS WITH ID

    // this interface acts as a contract to say what your class CAN do, without defining how it works inside yet.
    // It extends JpaRepo to inherit all the methods and Item is the type of object this repo woirks with and String
    // is the type of the ID (primary key, id in Item.java)

    // for ex., now you can do things like:
    // itemRepository.save(new Item("Macbook", "L01", 5)); --> add item
    // itemRepository.findAll(); --> get all items
    // etc
}
