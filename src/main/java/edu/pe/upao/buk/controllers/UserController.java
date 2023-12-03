package edu.pe.upao.buk.controllers;

import edu.pe.upao.buk.mappers.LoginRequest;
import edu.pe.upao.buk.models.User;
import edu.pe.upao.buk.services.AuthService;
import edu.pe.upao.buk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final AuthService authService;

    @Autowired
    public UserController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registration-form";  // Aquí debes crear una vista HTML para el formulario de registro
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody User user){
        try{
            String newUser = userService.registerUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (IllegalStateException sms){
            return new ResponseEntity<>(sms.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        String loginResult = authService.loginUser(email, password);

        return ResponseEntity.ok(loginResult);
    }
    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser() {
        try {
            String logoutResult = authService.logoutActiveUser();
            return ResponseEntity.ok(logoutResult);
        } catch (Exception e) {
            // Manejo de excepciones aquí
            return ResponseEntity.status(500).body("Error al cerrar sesión: " + e.getMessage());
        }
    }
}
