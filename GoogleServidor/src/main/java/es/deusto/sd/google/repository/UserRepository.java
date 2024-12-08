package es.deusto.sd.google.repository;

import es.deusto.sd.google.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Método para buscar un usuario por email
    Optional<User> findByEmail(String email);

    // Método para verificar si existe un usuario con un email específico
    boolean existsByEmail(String email);
}
