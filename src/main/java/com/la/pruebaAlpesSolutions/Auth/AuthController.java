package com.la.pruebaAlpesSolutions.Auth;

import com.la.pruebaAlpesSolutions.Entity.Usuario;
import com.la.pruebaAlpesSolutions.Jwt.JwtService;
import com.la.pruebaAlpesSolutions.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // Buscar usuario en la base de datos
        Usuario usuario = usuarioRepository.findByUsuarioNombre(request.getUsername()).orElse(null);

        if (usuario == null) {
            return ResponseEntity.status(401).body("Usuario no encontrado");
        }

        System.out.println("Contraseña ingresada: " + request.getPassword());
        System.out.println("Contraseña almacenada: " + usuario.getPassword());
        System.out.println("Coinciden? " + passwordEncoder.matches(request.getPassword(), usuario.getPassword()));

        // Comparar la contraseña ingresada con la almacenada (hasheada)
        if (passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            String token = jwtService.generarToken(request.getUsername());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }


    @GetMapping("/test-hash")
    public void testPasswordHash() {
        String rawPassword = "123456";
        String encodedPassword = "$2a$10$QjG3Z7BZl5q5sMeB4uFJUOn9WQ/EXN9kk0Zx54FZWDbNnvymBq.jK";

        System.out.println("¿Las contraseñas coinciden? " + passwordEncoder.matches(rawPassword, encodedPassword));
    }
}
