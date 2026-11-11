package com.example.sitemaferreteriaartola.service;

import com.example.sitemaferreteriaartola.entity.usuarioentity;
import com.example.sitemaferreteriaartola.repository.usuariorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class usuarioserviceIMPL implements usuarioservice {

    @Autowired
    private usuariorepository usuariorepository;

    @Override
    public List<usuarioentity> listarUsuarios() {
        return usuariorepository.findAll();
    }

    @Override
    public void guardarUsuario(usuarioentity usuario) {
        try {
            if (usuario.getIdusuario() == null) {
                boolean cedulaExiste = usuariorepository.findAll().stream()
                        .anyMatch(u -> u.getCedula() != null && u.getCedula().equalsIgnoreCase(usuario.getCedula()));
                if (cedulaExiste) {
                    throw new RuntimeException("Ya existe un usuario registrado con esta cédula.");
                }
            }
            usuariorepository.save(usuario);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage() != null ? e.getMessage() : "Error al guardar el usuario. Verifique datos duplicados.");
        }
    }

    @Override
    public Optional<usuarioentity> buscarPorId(Integer id) {
        return usuariorepository.findById(id);
    }
}