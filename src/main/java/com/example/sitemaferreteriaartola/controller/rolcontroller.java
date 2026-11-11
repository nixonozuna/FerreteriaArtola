package com.example.sitemaferreteriaartola.controller;

import com.example.sitemaferreteriaartola.entity.rolentity;
import com.example.sitemaferreteriaartola.service.rolservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}