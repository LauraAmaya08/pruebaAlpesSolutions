package com.la.pruebaAlpesSolutions.Repository;


import com.la.pruebaAlpesSolutions.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsuarioNombre(String usuarioNombre);
}
