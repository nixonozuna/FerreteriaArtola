package com.example.sitemaferreteriaartola.service;

import com.example.sitemaferreteriaartola.entity.categoriaproductoentity;
import java.util.List;
import java.util.Optional;

public interface categoriaproductoservice {
    List<categoriaproductoentity> listarCategoriaProducto();
    void guardarCategoriaProducto(categoriaproductoentity categoriaproducto);
    Optional<categoriaproductoentity> buscarPorId(Integer id);
}