package com.example.sitemaferreteriaartola.controller;

import com.example.sitemaferreteriaartola.entity.categoriaproductoentity;
import com.example.sitemaferreteriaartola.repository.categoriaproductorepository;
import com.example.sitemaferreteriaartola.service.categoriaproductoservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categoriasproductos")
public class categoriaproductocontroller {

    @Autowired
    private categoriaproductoservice categoriaproductoService;

    @Autowired
    private categoriaproductorepository categoriaproductorepository;

    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaproductoService.listarCategoriaProducto());
        model.addAttribute("categoriaproducto", new categoriaproductoentity());

        categoriaproductoentity ultimacategoria = categoriaproductorepository.findTopByOrderByIdcategoriaproductoDesc();
        String siguientecodigo = "CAT-001";
        if (ultimacategoria != null && ultimacategoria.getCodigocategoriaproducto() != null) {
            String codigoActual = ultimacategoria.getCodigocategoriaproducto();
            int numero = Integer.parseInt(codigoActual.replace("CAT-", "")) + 1;
            siguientecodigo = String.format("CAT-%03d", numero);
        }
        model.addAttribute("siguientecodigo", siguientecodigo);

        return "categoriasproductos";
    }

    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute @Valid categoriaproductoentity categoriaproducto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categorias", categoriaproductoService.listarCategoriaProducto());

            categoriaproductoentity ultimacategoria = categoriaproductorepository.findTopByOrderByIdcategoriaproductoDesc();
            String siguientecodigo = "CAT-001";
            if (ultimacategoria != null && ultimacategoria.getCodigocategoriaproducto() != null) {
                String codigoActual = ultimacategoria.getCodigocategoriaproducto();
                int numero = Integer.parseInt(codigoActual.replace("CAT-", "")) + 1;
                siguientecodigo = String.format("CAT-%03d", numero);
            }
            model.addAttribute("siguientecodigo", siguientecodigo);
            return "categoriasproductos";
        }

        try {
            categoriaproductoService.guardarCategoriaProducto(categoriaproducto);
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("categorias", categoriaproductoService.listarCategoriaProducto());

            categoriaproductoentity ultimacategoria = categoriaproductorepository.findTopByOrderByIdcategoriaproductoDesc();
            String siguientecodigo = "CAT-001";
            if (ultimacategoria != null && ultimacategoria.getCodigocategoriaproducto() != null) {
                String codigoActual = ultimacategoria.getCodigocategoriaproducto();
                int numero = Integer.parseInt(codigoActual.replace("CAT-", "")) + 1;
                siguientecodigo = String.format("CAT-%03d", numero);
            }
            model.addAttribute("siguientecodigo", siguientecodigo);
            return "categoriasproductos";
        }

        return "redirect:/categoriasproductos";
    }
}