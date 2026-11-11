package com.example.sitemaferreteriaartola.controller;

import com.example.sitemaferreteriaartola.entity.productoentity;
import com.example.sitemaferreteriaartola.repository.productorepository;
import com.example.sitemaferreteriaartola.service.categoriaproductoservice;
import com.example.sitemaferreteriaartola.service.productoservice;
import com.example.sitemaferreteriaartola.service.unidadmedidaservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class productocontroller {

    @Autowired
    private productoservice productoService;

    @Autowired
    private productorepository productoRepository;

    @Autowired
    private categoriaproductoservice categoriaProductoService;

    @Autowired
    private unidadmedidaservice unidadMedidaService;

    private void cargarAtributosModel(Model model, String codigoSiguiente, String barraSiguiente) {
        model.addAttribute("productos", productoService.listarProductos());
        model.addAttribute("categorias", categoriaProductoService.listarCategoriaProducto());
        model.addAttribute("unidades", unidadMedidaService.listarUnidadMedida());
        model.addAttribute("siguientecodigo", codigoSiguiente);
        model.addAttribute("siguientecodigobarra", barraSiguiente);
    }

    private String obtenerSiguienteCodigoProducto() {
        productoentity ultimoproducto = productoRepository.findTopByOrderByIdproductoDesc();
        if (ultimoproducto != null && ultimoproducto.getCodigoproducto() != null) {
            int numero = Integer.parseInt(ultimoproducto.getCodigoproducto().replace("PROD-", "")) + 1;
            return String.format("PROD-%03d", numero);
        }
        return "PROD-001";
    }

    private String obtenerSiguienteCodigoBarra() {
        productoentity ultimobarra = productoRepository.findTopByOrderByCodigobarraDesc();
        if (ultimobarra != null && ultimobarra.getCodigobarra() != null) {
            try {
                int numBarra = Integer.parseInt(ultimobarra.getCodigobarra()) + 1;
                return String.format("%08d", numBarra);
            } catch (Exception e) {
                return "77500001";
            }
        }
        return "77500001";
    }

    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("producto", new productoentity());
        cargarAtributosModel(model, obtenerSiguienteCodigoProducto(), obtenerSiguienteCodigoBarra());
        return "productos";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute @Valid productoentity producto, BindingResult bindingResult, Model model) {
        String siguientecodigo = obtenerSiguienteCodigoProducto();
        String siguientecodigobarra = obtenerSiguienteCodigoBarra();

        if (bindingResult.hasErrors()) {
            cargarAtributosModel(model, siguientecodigo, siguientecodigobarra);
            return "productos";
        }

        try {
            productoService.guardarProducto(producto);
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            cargarAtributosModel(model, siguientecodigo, siguientecodigobarra);
            return "productos";
        }

        return "redirect:/productos";
    }
}