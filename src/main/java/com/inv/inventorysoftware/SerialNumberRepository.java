package com.inv.inventorysoftware;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SerialNumberRepository extends JpaRepository<SerialNumber, Long> {
    List<SerialNumber> findByItemId(String itemId); // this gets all serials for one item
}

// this class lets Spring talk to the serial_number table