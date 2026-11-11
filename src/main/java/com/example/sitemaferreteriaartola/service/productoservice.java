package com.example.sitemaferreteriaartola.service;

import com.example.sitemaferreteriaartola.entity.productoentity;
import java.util.List;
import java.util.Optional;

public interface productoservice {
    List<productoentity> listarProductos();
    void guardarProducto(productoentity producto);
    Optional<productoentity> buscarPorId(Integer id);
}