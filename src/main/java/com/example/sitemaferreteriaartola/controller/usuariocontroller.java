package com.example.sitemaferreteriaartola.controller;

import com.example.sitemaferreteriaartola.entity.usuarioentity;
import com.example.sitemaferreteriaartola.repository.usuariorepository;
import com.example.sitemaferreteriaartola.service.usuarioservice;
import com.example.sitemaferreteriaartola.service.rolservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class usuariocontroller {

    @Autowired
    private usuarioservice usuarioService;

    @Autowired
    private rolservice rolService;

    @Autowired
    private usuariorepository usuariorepository;

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        model.addAttribute("roles", rolService.listarRoles());
        model.addAttribute("usuario", new usuarioentity());

        usuarioentity ultimousuario = usuariorepository.findTopByOrderByIdusuarioDesc();
        String siguientecodigo = "USU-001";
        if (ultimousuario != null && ultimousuario.getCodigousuario() != null) {
            String codigoActual = ultimousuario.getCodigousuario();
            int numero = Integer.parseInt(codigoActual.replace("USU-", "")) + 1;
            siguientecodigo = String.format("USU-%03d", numero);
        }
        model.addAttribute("siguientecodigo", siguientecodigo);

        return "usuarios";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute @Valid usuarioentity usuario, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("usuarios", usuarioService.listarUsuarios());
            model.addAttribute("roles", rolService.listarRoles());

            usuarioentity ultimousuario = usuariorepository.findTopByOrderByIdusuarioDesc();
            String siguientecodigo = "USU-001";
            if (ultimousuario != null && ultimousuario.getCodigousuario() != null) {
                String codigoActual = ultimousuario.getCodigousuario();
                int numero = Integer.parseInt(codigoActual.replace("USU-", "")) + 1;
                siguientecodigo = String.format("USU-%03d", numero);
            }
            model.addAttribute("siguientecodigo", siguientecodigo);
            return "usuarios";
        }

        try {
            usuarioService.guardarUsuario(usuario);
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("usuarios", usuarioService.listarUsuarios());
            model.addAttribute("roles", rolService.listarRoles());

            usuarioentity ultimousuario = usuariorepository.findTopByOrderByIdusuarioDesc();
            String siguientecodigo = "USU-001";
            if (ultimousuario != null && ultimousuario.getCodigousuario() != null) {
                String codigoActual = ultimousuario.getCodigousuario();
                int numero = Integer.parseInt(codigoActual.replace("USU-", "")) + 1;
                siguientecodigo = String.format("USU-%03d", numero);
            }
            model.addAttribute("siguientecodigo", siguientecodigo);
            return "usuarios";
        }

        return "redirect:/usuarios";
    }
}