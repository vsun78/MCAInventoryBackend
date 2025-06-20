package com.inv.inventorysoftware;

import com.inv.inventorysoftware.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}

// so now you dont have to write whole SQL statements, you just use the Java syntax to access SQL