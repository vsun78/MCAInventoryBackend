
/*package com.inv.inventorysoftware;

// so in general, a controller is a Java class in Spring Boot that listens for HTTP requests and then responds with data/actions
// it acts as a bridge between the frontend and the database / your code

import org.springframework.beans.factory.annotation.Autowired; // --> lets you use autowired
import org.springframework.web.bind.annotation.*; // --> gives you all the other web annotations

import java.util.List; // --> using a List<Item> to return all items from the database (standard Java stuff)

@RestController
// turns your class into a REST API controller, meaning that this class can receive HTTP requests and send back JSON responses
@RequestMapping("/api/items")
@CrossOrigin(origins = "*") // allow frontend access
public class ItemController {

    // Autowired connects to your database helper
    // example: instead of creating a new ItemRepository manually, Spring gives it to you:
    @Autowired
    private ItemRepository itemRepository;

    // 1️⃣ GET /api/items → List all items
    @GetMapping // tells Spring Boot to call this method when someone makes a GET request to https://localhost:8080/api/items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
        // ok so example:
        // if you have a DB with 3 things, this function returns all 3 items as a JSON list when a GET request is sent to /api/items
    }

    // 2️⃣ POST /api/items → Add a new item
    @PostMapping
    public Item addItem(@RequestBody Item item) { //RequestBody Item item tells spring "take the JSON in the request body and turn it into an Item object"
        return itemRepository.save(item); // saves the item into the DB. Updates it if it already exists.
    }

    // 3️⃣ POST /api/items/{id}/increment → Add 1 to quantity
    @PostMapping("/{id}/increment") // handles POST requests like /api/items/M01/increment
    public Item increment(@PathVariable String id) {
        Item item = itemRepository.findById(id).orElseThrow(); // looks up the item in the DB by its id
        item.setQuantity(item.getQuantity() + 1); // increases the quantity of the item by 1.
        return itemRepository.save(item); // saves the updated item back to the DB
    }

    // 4️⃣ POST /api/items/{id}/decrement → Subtract 1 from quantity
    @PostMapping("/{id}/decrement")
    public Item decrement(@PathVariable String id) {
        Item item = itemRepository.findById(id).orElseThrow();
        item.setQuantity(item.getQuantity() - 1);
        return itemRepository.save(item);
    }
}
-- old --
 */

package com.inv.inventorysoftware;

// so in general, a controller is a Java class in Spring Boot that listens for HTTP requests and then responds with data/actions
// it acts as a bridge between the frontend and the database / your code

import org.springframework.beans.factory.annotation.Autowired; // --> lets you use autowired

import org.springframework.web.bind.annotation.*; // --> gives you all the other web annotations

import java.util.List; // --> using a List<Item> to return all items from the database (standard Java stuff)

// these annotations above the class control how the class behaves in the web/API world.

@RestController
// turns your class into a REST API controller, meaning that this class can receive HTTP requests and send back JSON responses
@RequestMapping("/api/items")
@CrossOrigin(origins = "*") // allow frontend access

public class ItemController {

    // Autowired connects to your database helper
    // example: instead of creating a new ItemRepository manually, Spring gives it to you:
    @Autowired
    private ItemRepository itemRepository;

    // 1️⃣ GET /api/items → List all items
    @GetMapping // tells Spring Boot to call this method when someone makes a GET request to https://localhost:8080/api/items
    // so it's like saying "when someone wants to get all the items, use this function"

    public List<Item> getAllItems() // and as follows from the above, this function has the List of Item objects as the return type
    {
        return itemRepository.findAll();


        // ok so example:
        // if you have a DB with 3 things, this function returns all 3 items as a JSON list when a GET request is sent to /api/items
    }

    // 2️⃣ POST /api/items → Add a new item
    @PostMapping
    public Item addItem(@RequestBody Item item) { //RequestBody Item item tells spring "take the JSON in the request body and
        // turn it into an Item object
        return itemRepository.save(item); // saves the item into the DB. Updates it if it already exists.
    }

    // 3️⃣ POST /api/items/{id}/increment → Add 1 to quantity
    @PostMapping("/{id}/increment") // handles POST requsts like /api/items/M01/increment
    public Item increment(@PathVariable String id) { // gets the {id} from the URL. For example, if the URL is the above one, id will be M01.
        Item item = itemRepository.findById(id).orElseThrow(); // looks up the item in the DB by its id
        item.setQuantity(item.getQuantity() + 1); // increases the quantity of the item by 1.
        return itemRepository.save(item); // saves the updated item back to the DB

        /* example:
Before: { "id": "M01", "name": "Dell Monitor", "quantity": 10 }
After: { "id": "M01", "name": "Dell Monitor", "quantity": 11 }
         */
    }

    // 4️⃣ POST /api/items/{id}/decrement → Subtract 1 from quantity
    @PostMapping("/{id}/decrement")
    public Item decrement(@PathVariable String id) {
        Item item = itemRepository.findById(id).orElseThrow();
        item.setQuantity(item.getQuantity() - 1);
        return itemRepository.save(item);
    }
}

