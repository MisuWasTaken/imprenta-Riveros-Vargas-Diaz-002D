package com.imprenta.service_auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.imprenta.service_auth.model.Usuario;
import com.imprenta.service_auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticación", description = "Endpoints para registro y login de usuarios")
public class AutenticacionController {
    @Autowired
    private AuthService authService;
    @Operation(summary = "Registrar un nuevo usuario", description = "Enctripta todo asi re zarpado dou contraseña y usuario")
    @PostMapping("/register")
    public ResponseEntity<String> registrar(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(authService.registrar(usuario));
    }
    @Operation(summary = "inicio de sesion", description = "Devuelve un token JWT si esta todo bien en cuanto a las credenciales")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        try {
            String token = authService.login(usuario.getNombreUsuario(), usuario.getContraseña());
            return ResponseEntity.ok(token);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
