package com.example.sitemaferreteriaartola.controller;

import com.example.sitemaferreteriaartola.repository.rolrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/roles")
public class rolcontroller {

    @Autowired
    private rolrepository rolrepository;

    @GetMapping("")
    @ResponseBody
    public String listarRoles() {
        try {
            long total = rolrepository.count();
            var roles = rolrepository.findAll();
            return "¡Conexión exitosa con Supabase! Total de roles: " + total + " | Datos: " + roles.toString();
        } catch (Exception e) {
            return "Error al consultar Supabase: " + e.getMessage();
        }
    }
}