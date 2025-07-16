package com.dmspro.backend.service;

import com.dmspro.backend.model.User;
import com.dmspro.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> loginUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            System.out.println("🔍 User found: " + userOptional.get().getEmail());
            System.out.println("🔑 DB Password: " + userOptional.get().getPassword());
            System.out.println("🔑 Entered Password: " + password);
        } else {
            System.out.println("❌ No user found with email: " + email);
        }

        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            return userOptional;
        } else {
            return Optional.empty();
        }
    }

    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
