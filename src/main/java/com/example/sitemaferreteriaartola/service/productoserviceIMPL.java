package com.example.sitemaferreteriaartola.service;

import com.example.sitemaferreteriaartola.entity.productoentity;
import com.example.sitemaferreteriaartola.repository.productorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class productoserviceIMPL implements productoservice {

    @Autowired
    private productorepository productoRepository;

    @Override
    public List<productoentity> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public void guardarProducto(productoentity producto) {
        try {
            // SOLO GENERA CÓDIGOS NUEVOS SI ES UN REGISTRO NUEVO (ID ES NULL)
            if (producto.getIdproducto() == null) {
                // 1. Generar Código Correlativo de Producto (PROD-001)
                productoentity ultimoproducto = productoRepository.findTopByOrderByIdproductoDesc();
                String nuevocodigo = "PROD-001";
                if (ultimoproducto != null && ultimoproducto.getCodigoproducto() != null) {
                    int numero = Integer.parseInt(ultimoproducto.getCodigoproducto().replace("PROD-", "")) + 1;
                    nuevocodigo = String.format("PROD-%03d", numero);
                }
                producto.setCodigoproducto(nuevocodigo);

                // 2. Generar Código de Barra Numérico Automático (77500001)
                productoentity ultimobarra = productoRepository.findTopByOrderByCodigobarraDesc();
                String nuevobarra = "77500001";
                if (ultimobarra != null && ultimobarra.getCodigobarra() != null) {
                    try {
                        int numBarra = Integer.parseInt(ultimobarra.getCodigobarra()) + 1;
                        nuevobarra = String.format("%08d", numBarra);
                    } catch (NumberFormatException e) {
                        nuevobarra = "77500001";
                    }
                }
                producto.setCodigobarra(nuevobarra);
            }

            productoRepository.save(producto);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage() != null ? e.getMessage() : "Error al guardar el producto en la base de datos.");
        }
    }

    @Override
    public Optional<productoentity> buscarPorId(Integer id) {
        return productoRepository.findById(id);
    }
}