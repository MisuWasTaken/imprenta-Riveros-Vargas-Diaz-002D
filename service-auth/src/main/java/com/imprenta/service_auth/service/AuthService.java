package com.imprenta.service_auth.service;

import org.springframework.stereotype.Service;


@Service
public class AuthService {
    @Autowired private UsuarioRepository usuarioRepo;
    @Autowired private JwtService jwtService;
    @Autowired private PasswordEncoder passwordEncoder;

    public String registrar(Usuario Usuario){
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
