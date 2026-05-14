package com.imprenta.service_usuarios.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imprenta.service_usuarios.model.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> 
{
    List<Usuario> findByNombreContainingIgnoreCase(String nombre);

    List<Usuario> findByApellidoContainingIgnoreCase(String apellido);

    Usuario findByCorreo(String correo);

}
