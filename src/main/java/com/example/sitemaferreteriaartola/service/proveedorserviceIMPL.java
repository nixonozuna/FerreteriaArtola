package com.example.sitemaferreteriaartola.service;

import com.example.sitemaferreteriaartola.entity.proveedorentity;
import com.example.sitemaferreteriaartola.repository.proveedorrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class proveedorserviceIMPL implements proveedorservice {

    @Autowired
    private proveedorrepository proveedorrepository;

    @Override
    public List<proveedorentity> listarProveedores() {
        return proveedorrepository.findAll();
    }

    @Override
    public void guardarProveedor(proveedorentity proveedor) {
        try {
            if (proveedor.getIdproveedor() == null) {
                proveedorentity ultimoproveedor = proveedorrepository.findTopByOrderByIdproveedorDesc();
                String nuevocodigo = "PROV-001";

                if (ultimoproveedor != null && ultimoproveedor.getCodigoproveedor() != null) {
                    String codigoActual = ultimoproveedor.getCodigoproveedor();
                    int numero = Integer.parseInt(codigoActual.replace("PROV-", "")) + 1;
                    nuevocodigo = String.format("PROV-%03d", numero);
                }
                proveedor.setCodigoproveedor(nuevocodigo);
            }

            proveedorrepository.save(proveedor);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage() != null ? e.getMessage() : "Error al guardar el proveedor.");
        }
    }

    @Override
    public Optional<proveedorentity> buscarPorId(Integer id) {
        return proveedorrepository.findById(id);
    }
}