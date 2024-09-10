package com.miapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miapp.service.UsuarioService;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";  // Muestra la página de login
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, 
                        @RequestParam("password") String password, Model model) {
        // Lógica para validar usuario con email y contraseña
        if (usuarioService.validarUsuario(email, password)) {
            return "redirect:/bienvenida";  // Redirige a la página de bienvenida
        } else {
            model.addAttribute("error", "Email o contraseña incorrectos");
            return "login";  // Devuelve a la página de login en caso de error
        }
    }
}
