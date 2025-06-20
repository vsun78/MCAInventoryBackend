
/*package com.inv.inventorysoftware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private static final String ALLOWED_USERNAME = "admin";

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginInput) {
        String inputUsername = loginInput.getUsername();
        String inputPassword = loginInput.getPassword();

        // Only allow 'admin' to log in
        if (!ALLOWED_USERNAME.equals(inputUsername)) {
            return ResponseEntity.status(401).body("Only 'admin' is allowed to log in");
        }

        Optional<User> userOpt = userRepo.findByUsername(inputUsername);
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(401).body("Admin account not found");
        }

        User user = userOpt.get();
        if (!passwordEncoder.matches(inputPassword, user.getPassword())) {
            return ResponseEntity.status(403).body("Incorrect password");
        }

        return ResponseEntity.ok("Login successful");
    }

    // Disable registration
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User userInput) {
        return ResponseEntity.status(403).body("Registration is disabled");
    }
}

 */


package com.inv.inventorysoftware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Adjust to your frontend URL
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        System.out.println("Login attempt for username: " + loginRequest.getUsername());

        Optional<User> userOpt = userRepo.findByUsername(loginRequest.getUsername());
        if (userOpt.isEmpty()) {
            System.out.println("User not found");
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        User user = userOpt.get();
        System.out.println("Stored password hash: " + user.getPassword());

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            System.out.println("Password does not match");
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        System.out.println("Login successful");
        return ResponseEntity.ok().body(new LoginResponse("Login successful", user.getUsername()));
    }

    // Inner classes for request/response
    public static class LoginRequest {
        private String username;
        private String password;

        // Getters and Setters
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

    public static class LoginResponse {
        private String message;
        private String username;

        public LoginResponse(String message, String username) {
            this.message = message;
            this.username = username;
        }

        // Getters
        public String getMessage() {
            return message;
        }

        public String getUsername() {
            return username;
        }
    }
}

