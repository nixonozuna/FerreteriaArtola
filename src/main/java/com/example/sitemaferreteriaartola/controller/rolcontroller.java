package com.example.sitemaferreteriaartola.controller;

import com.example.sitemaferreteriaartola.repository.rolrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class rolcontroller {

    @Autowired
    private rolrepository rolrepository;

    @GetMapping("")
    public String listarRoles(Model model) {
        model.addAttribute("roles", rolrepository.findAll());
        return "roles"; // Nombre de tu archivo html de roles
    }
}