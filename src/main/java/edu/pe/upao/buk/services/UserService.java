package edu.pe.upao.buk.services;

import edu.pe.upao.buk.models.Reniec;
import edu.pe.upao.buk.models.Rol;
import edu.pe.upao.buk.models.User;
import edu.pe.upao.buk.repositories.ReniecRepository;
import edu.pe.upao.buk.repositories.UserRepository;
import org.springframework.stereotype.*;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final ReniecRepository reniecRepository;
    public UserService(UserRepository userRepository, ReniecRepository reniecRepository) {
        this.userRepository = userRepository;
        this.reniecRepository = reniecRepository;
    }

    public String registerUser(User user) {

        // Verificar si el correo o DNI ya están registrados
        if (userRepository.existsByDni(user.getDni())) {
            return "El DNI ya está registrado";
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            return "El correo ya está registrado";
        }

        if(userRepository.existsByCellphone(user.getCellphone())){
            return "El celular ya esta registrado";
        }
        // Obtener información de Reniec
        Reniec reniecInfo = reniecRepository.findByDni(user.getDni());

        // Verificar si los nombres y apellidos coinciden con Reniec
        if (reniecInfo == null || !reniecInfo.getFirstNameDNI().equals(user.getFirstName())
                || !reniecInfo.getLastNameDNI().equals(user.getLastName())) {
            return "Los nombres y apellidos no coinciden con la información de Reniec";
        }

        // Asignar el rol por defecto "Postulante"
        user.setRol(Rol.Postulante);

        // Guardar usuario en la base de datos
        userRepository.save(user);

        return "Registro exitoso";
    }
    public void guardarSesionUsuario(User usuario) {
        // Verificar si el usuario ya está registrado como "logueado"
        Boolean isLoggedIn = usuario.getIsLoggedIn();
        if (isLoggedIn == null || !isLoggedIn.booleanValue()) {
            // Actualizar el estado de la sesión del usuario a "logueado"
            usuario.setIsLoggedIn(Boolean.TRUE);
            userRepository.save(usuario);
            System.out.println("Sesión del usuario " + usuario.getEmail() + " guardada con éxito.");
        } else {
            System.out.println("El usuario " + usuario.getEmail() + " ya está logueado.");
        }
    }
}
