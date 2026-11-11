package com.example.sitemaferreteriaartola.service;

import com.example.sitemaferreteriaartola.entity.proveedorentity;
import java.util.List;
import java.util.Optional;

public interface proveedorservice {
    List<proveedorentity> listarProveedores();
    void guardarProveedor(proveedorentity proveedor);
    Optional<proveedorentity> buscarPorId(Integer id);
}