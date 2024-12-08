package es.deusto.sd.google.service;

import es.deusto.sd.google.entity.User;
import es.deusto.sd.google.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor para la inyección de dependencias
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Método para registrar un usuario
    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("El email ya está registrado");
        }
        return userRepository.save(user); // Guarda el usuario en la base de datos
    }

    // Método para validar las credenciales de un usuario
    public Optional<User> validateUser(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(password)); // Verifica si la contraseña coincide
    }

    // Método adicional: Obtener un usuario por email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
