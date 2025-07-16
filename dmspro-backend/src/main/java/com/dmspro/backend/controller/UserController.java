package com.dmspro.backend.controller;

import com.dmspro.backend.model.User;
import com.dmspro.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.emailExists(user.getEmail())) {
            return ResponseEntity.badRequest().body(Map.of("message", "⚠️ Email already registered"));
        }
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(Map.of(
                "message", "✅ Registered successfully",
                "user", savedUser
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginData) {
        Optional<User> user = userService.loginUser(loginData.getEmail(), loginData.getPassword());
        if (user.isPresent()) {
            return ResponseEntity.ok(Map.of(
                "message", "✅ Login successful",
                "user", user.get()
            ));
        } else {
            return ResponseEntity.status(401).body(Map.of("message", "❌ Invalid email or password"));
        }
    }
}
