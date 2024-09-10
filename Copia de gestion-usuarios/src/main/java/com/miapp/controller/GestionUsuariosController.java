package com.miapp.controller;

import com.miapp.model.Usuario;
import com.miapp.service.UsuarioService;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GestionUsuariosController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/gestion")
    public String gestionUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.getAllUsuarios());
        return "gestion";
    }

    @PostMapping("/gestion/agregar")
    public String agregarUsuario(
        @RequestParam("email") String email,
        @RequestParam("nombre") String nombre,
        @RequestParam("password") String password,
        @RequestParam("status") String status,
        @RequestParam("fechaCaducidad") String fechaCaducidad
    ) {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setNombre(nombre);
        usuario.setPassword(passwordEncoder.encode(password));
        usuario.setStatus(status);
        usuario.setFechaCaducidad(LocalDate.parse(fechaCaducidad));
        usuarioService.save(usuario);
        return "redirect:/gestion";
    }
}
