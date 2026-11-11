package com.example.sitemaferreteriaartola.controller;

import com.example.sitemaferreteriaartola.entity.proveedorentity;
import com.example.sitemaferreteriaartola.repository.proveedorrepository;
import com.example.sitemaferreteriaartola.service.proveedorservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proveedores")
public class proveedorcontroller {

    @Autowired
    private proveedorservice proveedorService;

    @Autowired
    private proveedorrepository proveedorrepository;

    @GetMapping
    public String listarProveedores(Model model) {
        model.addAttribute("proveedores", proveedorService.listarProveedores());
        model.addAttribute("proveedor", new proveedorentity());

        proveedorentity ultimoproveedor = proveedorrepository.findTopByOrderByIdproveedorDesc();
        String siguientecodigo = "PROV-001";
        if (ultimoproveedor != null && ultimoproveedor.getCodigoproveedor() != null) {
            String codigoActual = ultimoproveedor.getCodigoproveedor();
            int numero = Integer.parseInt(codigoActual.replace("PROV-", "")) + 1;
            siguientecodigo = String.format("PROV-%03d", numero);
        }
        model.addAttribute("siguientecodigo", siguientecodigo);

        return "proveedores";
    }

    @PostMapping("/guardar")
    public String guardarProveedor(@ModelAttribute @Valid proveedorentity proveedor, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("proveedores", proveedorService.listarProveedores());

            proveedorentity ultimoproveedor = proveedorrepository.findTopByOrderByIdproveedorDesc();
            String siguientecodigo = "PROV-001";
            if (ultimoproveedor != null && ultimoproveedor.getCodigoproveedor() != null) {
                String codigoActual = ultimoproveedor.getCodigoproveedor();
                int numero = Integer.parseInt(codigoActual.replace("PROV-", "")) + 1;
                siguientecodigo = String.format("PROV-%03d", numero);
            }
            model.addAttribute("siguientecodigo", siguientecodigo);
            return "proveedores";
        }

        try {
            proveedorService.guardarProveedor(proveedor);
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("proveedores", proveedorService.listarProveedores());

            proveedorentity ultimoproveedor = proveedorrepository.findTopByOrderByIdproveedorDesc();
            String siguientecodigo = "PROV-001";
            if (ultimoproveedor != null && ultimoproveedor.getCodigoproveedor() != null) {
                String codigoActual = ultimoproveedor.getCodigoproveedor();
                int numero = Integer.parseInt(codigoActual.replace("PROV-", "")) + 1;
                siguientecodigo = String.format("PROV-%03d", numero);
            }
            model.addAttribute("siguientecodigo", siguientecodigo);
            return "proveedores";
        }

        return "redirect:/proveedores";
    }
}