package com.example.sitemaferreteriaartola.controller;

import com.example.sitemaferreteriaartola.entity.unidadmedidaentity;
import com.example.sitemaferreteriaartola.repository.unidadmedidarepository;
import com.example.sitemaferreteriaartola.service.unidadmedidaservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/unidadesmedidas")
public class unidadmedidacontroller {

    @Autowired
    private unidadmedidaservice unidadmedidaService;

    @Autowired
    private unidadmedidarepository unidadmedidarepository;

    @GetMapping
    public String listarUnidadesMedida(Model model) {
        model.addAttribute("unidades", unidadmedidaService.listarUnidadMedida());
        model.addAttribute("unidadmedida", new unidadmedidaentity());

        unidadmedidaentity ultimaunidad = unidadmedidarepository.findTopByOrderByIdunidadmedidaDesc();
        String siguientecodigo = "UNIMED-001";

        if (ultimaunidad != null && ultimaunidad.getCodigounidadmedida() != null) {
            String codigoActual = ultimaunidad.getCodigounidadmedida();
            int numero = Integer.parseInt(codigoActual.replace("UNIMED-", "")) + 1;
            siguientecodigo = String.format("UNIMED-%03d", numero);
        }

        model.addAttribute("siguientecodigo", siguientecodigo);

        return "unidadesmedidas";
    }

    @PostMapping("/guardar")
    public String guardarUnidadMedida(@ModelAttribute("unidadmedida") @Valid unidadmedidaentity unidadmedida, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("unidades", unidadmedidaService.listarUnidadMedida());

            unidadmedidaentity ultimaunidad = unidadmedidarepository.findTopByOrderByIdunidadmedidaDesc();
            String siguientecodigo = "UNIMED-001";
            if (ultimaunidad != null && ultimaunidad.getCodigounidadmedida() != null) {
                String codigoActual = ultimaunidad.getCodigounidadmedida();
                int numero = Integer.parseInt(codigoActual.replace("UNIMED-", "")) + 1;
                siguientecodigo = String.format("UNIMED-%03d", numero);
            }
            model.addAttribute("siguientecodigo", siguientecodigo);
            return "unidadesmedidas";
        }

        try {
            unidadmedidaService.guardarUnidadMedida(unidadmedida);
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("unidades", unidadmedidaService.listarUnidadMedida());

            unidadmedidaentity ultimaunidad = unidadmedidarepository.findTopByOrderByIdunidadmedidaDesc();
            String siguientecodigo = "UNIMED-001";
            if (ultimaunidad != null && ultimaunidad.getCodigounidadmedida() != null) {
                String codigoActual = ultimaunidad.getCodigounidadmedida();
                int numero = Integer.parseInt(codigoActual.replace("UNIMED-", "")) + 1;
                siguientecodigo = String.format("UNIMED-%03d", numero);
            }
            model.addAttribute("siguientecodigo", siguientecodigo);
            return "unidadesmedidas";
        }

        return "redirect:/unidadesmedidas";
    }
}