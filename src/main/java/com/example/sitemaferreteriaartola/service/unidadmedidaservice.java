package com.example.sitemaferreteriaartola.service;

import com.example.sitemaferreteriaartola.entity.unidadmedidaentity;
import java.util.List;
import java.util.Optional;

public interface unidadmedidaservice {
    List<unidadmedidaentity> listarUnidadMedida();
    void guardarUnidadMedida(unidadmedidaentity unidadmedida);
    Optional<unidadmedidaentity> buscarPorId(Integer id);
}