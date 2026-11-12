package com.example.sitemaferreteriaartola.controller;

import com.example.sitemaferreteriaartola.entity.rolentity;
import com.example.sitemaferreteriaartola.service.rolservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class rolcontroller {

    @Autowired
    private rolservice rolService;

    @GetMapping
    public String listarRoles(Model model) {
        model.addAttribute("roles", rolService.listarRoles());
        model.addAttribute("rol", new rolentity());
        return "roles";
    }

    @PostMapping("/guardar")
    public String guardarRol(@ModelAttribute @Valid rolentity rol, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", rolService.listarRoles());
            return "roles";
        }

        try {
            // Aquí puedes agregar un método en tu service para guardar si lo requieres
            // rolService.guardarRol(rol);
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el rol: " + e.getMessage());
            model.addAttribute("roles", rolService.listarRoles());
            return "roles";
        }

        return "redirect:/roles";
    }
}