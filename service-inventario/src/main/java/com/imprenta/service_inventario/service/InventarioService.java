package com.imprenta.service_inventario.service;
import com.imprenta.service_inventario.model.Inventario;
import com.imprenta.service_inventario.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventarioService 
{

    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> listarTodos() {
        return inventarioRepository.findAll();
    }

    public List<Inventario> buscarPorNombre(String nombre) 
    {
        return inventarioRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public Inventario guardar(Inventario inventario) 
    {
        return inventarioRepository.save(inventario);
    }
    public Inventario actualizar(Long id, Inventario inventario) 
    {
        Inventario inventarioExistente = inventarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material no encontrado"));
        inventarioExistente.setNombre(inventario.getNombre());
        inventarioExistente.setCantidad(inventario.getCantidad());
        inventarioExistente.setDescripcion(inventario.getDescripcion());
        return inventarioRepository.save(inventarioExistente);
    }

    public void eliminar(Long id) 
    {
        inventarioRepository.deleteById(id);
    }

    public Inventario agregarCantidad(Long id, Integer cantidad) 
    {
        Inventario inventario = inventarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material no encontrado"));
        inventario.setCantidad(inventario.getCantidad() + cantidad);
        return inventarioRepository.save(inventario);
    }

    public Inventario quitarCantidad(Long id, Integer cantidad) 
    {
        Inventario inventario = inventarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material no encontrado"));
        inventario.setCantidad(inventario.getCantidad() - cantidad);
        return inventarioRepository.save(inventario);
    }
}