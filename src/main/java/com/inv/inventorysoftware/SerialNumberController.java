/*
package com.inv.inventorysoftware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class SerialNumberController {

    @Autowired
    private SerialNumberRepository serialRepo; // basically asking spring for access to the DB of serial numbers

    @GetMapping("/{itemId}/serials") // maps a GET request like GET /api/items/L01/serials (captures the itemID from the URL (L01,T02, etc))
    public List<SerialNumber> getSerialsForItem(@PathVariable String itemId) {
        return serialRepo.findByItemId(itemId); // returns a list of serilal numbers that match that item ID
        // so if the ID is L01, it sends back the serial numbers under that ID

        // pathvariable grabs the {itemId} and puts it into a Java variable called itemId

    }
}
*/

package com.inv.inventorysoftware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class SerialNumberController {

    @Autowired
    private SerialNumberRepository serialRepo;

    @Autowired
    private ItemRepository itemRepo;

    // ✅ GET all serials for an item
    @GetMapping("/{itemId}/serials")
    public List<SerialNumber> getSerialsForItem(@PathVariable String itemId) {
        return serialRepo.findByItemId(itemId);
    }

    // ✅ POST a new serial for a specific item
    @PostMapping("/{itemId}/serials")
    public SerialNumber addSerialNumber(@PathVariable String itemId, @RequestBody SerialNumber serialRequest) {
        Item item = itemRepo.findById(itemId).orElse(null);
        if (item == null) {
            throw new RuntimeException("Item not found with ID: " + itemId);
        }

        SerialNumber newSerial = new SerialNumber();
        newSerial.setSerial(serialRequest.getSerial());
        newSerial.setStatus(serialRequest.getStatus() != null ? serialRequest.getStatus() : "In Stock");
        newSerial.setDateAdded(new Date());
        newSerial.setItem(item);

        return serialRepo.save(newSerial);
    }
}
