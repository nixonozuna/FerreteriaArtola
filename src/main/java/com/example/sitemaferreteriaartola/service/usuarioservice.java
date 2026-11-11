package com.example.sitemaferreteriaartola.service;

import com.example.sitemaferreteriaartola.entity.usuarioentity;
import java.util.List;
import java.util.Optional;

public interface usuarioservice {
    List<usuarioentity> listarUsuarios();
    void guardarUsuario(usuarioentity usuario);
    Optional<usuarioentity> buscarPorId(Integer id);
}