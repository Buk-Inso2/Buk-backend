package edu.pe.upao.buk.Service;

import edu.pe.upao.buk.models.Reniec;
import edu.pe.upao.buk.models.Rol;
import edu.pe.upao.buk.models.User;
import edu.pe.upao.buk.repositories.ReniecRepository;
import edu.pe.upao.buk.repositories.UserRepository;
import edu.pe.upao.buk.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ReniecRepository reniecRepository;

    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository, reniecRepository);
    }

    @Test
    void testRegisterUser() {
        // Arrange
        User newUser = new User();
        newUser.setEmail("test@example.com");
        newUser.setCellphone("1223456789");
        newUser.setDni("12345678");
        newUser.setFirstName("John");
        newUser.setLastName("Doe");

        Reniec reniecInfo = new Reniec();
        reniecInfo.setDni("12345678");
        reniecInfo.setFirstNameDNI("John");
        reniecInfo.setLastNameDNI("Doe");

        when(userRepository.existsByEmail("test@example.com")).thenReturn(false);
        when(userRepository.existsByDni("12345678")).thenReturn(false);
        when(userRepository.existsByCellphone("123456709")).thenReturn(false);
        when(reniecRepository.findByDni("12345678")).thenReturn(reniecInfo);

        // Act
        String result = userService.registerUser(newUser);

        // Assert
        assertEquals("Registro exitoso", result);

    }
}