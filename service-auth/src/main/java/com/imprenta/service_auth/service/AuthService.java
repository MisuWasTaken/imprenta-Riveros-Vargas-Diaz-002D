package com.imprenta.service_auth.service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.imprenta.service_auth.model.Usuario;
import com.imprenta.service_auth.model.Rol;
import com.imprenta.service_auth.repository.UsuarioRepository;

@Service
public class AuthService {
    @Autowired private UsuarioRepository usuarioRepo;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private JwtService jwtService;

    public String registrar(Usuario usuario){
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        usuarioRepo.save(usuario);
        return "Usuario registrado correctamente";
    }

    public String login(String nombreUsuario, String contraseña){
        Usuario usuario = usuarioRepo.findByNombreUsuario(nombreUsuario)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (passwordEncoder.matches(contraseña, usuario.getContraseña())) {
            List<String> roles = usuario.getRoles().stream()
                    .map(Rol::getNombreRol).collect(Collectors.toList());
                return jwtService.generarToken(nombreUsuario, roles);
        }
        throw new RuntimeException("Contraseña incorrecta");
    }
}
