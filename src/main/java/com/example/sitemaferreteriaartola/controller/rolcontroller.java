package com.example.sitemaferreteriaartola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/roles")
public class rolcontroller {

    @GetMapping("")
    @ResponseBody
    public String listarRolesPrueba() {
        return "¡El despliegue en Render está funcionando correctamente!";
    }
}