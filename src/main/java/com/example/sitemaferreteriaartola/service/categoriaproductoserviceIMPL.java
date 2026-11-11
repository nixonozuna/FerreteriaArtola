package com.example.sitemaferreteriaartola.service;

import com.example.sitemaferreteriaartola.entity.categoriaproductoentity;
import com.example.sitemaferreteriaartola.entity.usuarioentity;
import com.example.sitemaferreteriaartola.repository.categoriaproductorepository;
import com.example.sitemaferreteriaartola.repository.usuariorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class categoriaproductoserviceIMPL implements categoriaproductoservice {

    @Autowired
    private categoriaproductorepository categoriaproductorepository;

    @Override
    public List<categoriaproductoentity> listarCategoriaProducto() {
        return categoriaproductorepository.findAll();
    }

    @Override
    public void guardarCategoriaProducto(categoriaproductoentity categoriaproducto) {
        try {
            if (categoriaproducto.getIdcategoriaproducto() == null) {
                boolean cedulaExiste = categoriaproductorepository.findAll().stream()
                        .anyMatch(u -> u.getNombre().equalsIgnoreCase(categoriaproducto.getNombre()));
                if (cedulaExiste) {
                    throw new RuntimeException("Ya existe una categoría producto registrada con este nombre");
                }

                categoriaproductoentity ultimocategoriaproducto = categoriaproductorepository.findTopByOrderByIdcategoriaproductoDesc();
                String nuevocodigo = "USU-001";

                if (ultimocategoriaproducto != null && ultimocategoriaproducto.getCodigocategoriaproducto() != null) {
                    String codigoActual = ultimocategoriaproducto.getCodigocategoriaproducto();
                    int numero = Integer.parseInt(codigoActual.replace("CAT-", "")) + 1;
                    nuevocodigo = String.format("CAT-%03d", numero);
                }
                categoriaproducto.setCodigocategoriaproducto(nuevocodigo);
            }
            categoriaproductorepository.save(categoriaproducto);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage() != null ? e.getMessage() : "Error al guardar la categoria producto. Verifique datos duplicados.");
        }
    }

    @Override
    public Optional<categoriaproductoentity> buscarPorId(Integer id) {
        return categoriaproductorepository.findById(id);
    }
}