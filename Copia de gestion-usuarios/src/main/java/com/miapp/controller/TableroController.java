package com.miapp.controller;

import com.miapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TableroController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/tablero")
    public String tablero(@RequestParam(value = "status", required = false) String status, Model model) {
        if (status != null) {
            model.addAttribute("usuarios", usuarioService.findByStatus(status));
        } else {
            model.addAttribute("usuarios", usuarioService.getAllUsuarios());
        }
        return "tablero";
    }
}
