package com.example.sitemaferreteriaartola.service;

import com.example.sitemaferreteriaartola.entity.unidadmedidaentity;
import com.example.sitemaferreteriaartola.repository.unidadmedidarepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class unidadmedidaserviceIMPL implements unidadmedidaservice {

    @Autowired
    private unidadmedidarepository unidadmedidarepository;

    @Override
    public List<unidadmedidaentity> listarUnidadMedida() {
        return unidadmedidarepository.findAll();
    }

    @Override
    public void guardarUnidadMedida(unidadmedidaentity unidadmedida) {
        try {
            if (unidadmedida.getIdunidadmedida() == null) {
                unidadmedidaentity ultimaunidad = unidadmedidarepository.findTopByOrderByIdunidadmedidaDesc();
                String nuevocodigo = "UNIMED-001";

                if (ultimaunidad != null && ultimaunidad.getCodigounidadmedida() != null) {
                    String codigoActual = ultimaunidad.getCodigounidadmedida();
                    int numero = Integer.parseInt(codigoActual.replace("UNIMED-", "")) + 1;
                    nuevocodigo = String.format("UNIMED-%03d", numero);
                }

                unidadmedida.setCodigounidadmedida(nuevocodigo);
            }

            unidadmedidarepository.save(unidadmedida);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage() != null ? e.getMessage() : "Error al guardar la unidad de medida.");
        }
    }

    @Override
    public Optional<unidadmedidaentity> buscarPorId(Integer id) {
        return unidadmedidarepository.findById(id);
    }
}