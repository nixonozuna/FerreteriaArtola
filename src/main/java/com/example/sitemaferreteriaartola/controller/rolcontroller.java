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
    public String listarRolesDebug() {
        try {
            long total = rolrepository.count();
            return "¡Conexión y consulta exitosas! Total de registros en la tabla rol: " + total;
        } catch (Exception e) {
            return "ERROR DETALLADO DE SUPABASE: " + e.getMessage();
        }
    }
}