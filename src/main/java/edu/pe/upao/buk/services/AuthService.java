package edu.pe.upao.buk.services;

import edu.pe.upao.buk.models.User;
import edu.pe.upao.buk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public AuthService(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public String loginUser(String email, String password) {
        // Verificar si ya hay un usuario logueado
        User activeUser = userRepository.findByIsLoggedInTrue().orElse(null);

        if (activeUser != null) {
            return "Ya hay un usuario con sesión iniciada: " + activeUser.getEmail();
        }

        // Buscar al usuario por correo en la base de datos
        User user = userRepository.findByEmail(email).orElse(null);

        // Verificar si el usuario existe y la contraseña coincide
        if (user != null && password.equals(user.getPassword())) {
            // El usuario ha iniciado sesión con éxito
            user.setIsLoggedIn(true);
            userRepository.save(user);
            return "Inicio de sesión exitoso";
        } else {
            // El usuario no existe o la contraseña es incorrecta
            return "Correo y/o contraseña incorrectos";
        }
    }
    public String logoutActiveUser() {
        // Buscar al usuario activo
        User activeUser = userRepository.findByIsLoggedInTrue().orElse(null);

        if (activeUser != null) {
            // Actualizar el estado de la sesión del usuario a "no logueado"
            activeUser.setIsLoggedIn(false);
            userRepository.save(activeUser);
            return "Cierre de sesión exitoso para: " + activeUser.getEmail();
        } else {
            return "No hay usuario activo para cerrar sesión";
        }
    }
}
