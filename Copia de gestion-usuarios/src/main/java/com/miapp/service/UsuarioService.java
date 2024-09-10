package com.miapp.service;

import com.miapp.model.Usuario;
import com.miapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> findByEmail(String email) {
        return Optional.ofNullable(usuarioRepository.findByEmail(email));
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Object findByStatus(String status) {
        throw new UnsupportedOperationException("Unimplemented method 'findByStatus'");
    }

    public Object getAllUsuarios() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsuarios'");
    }

    public boolean validarUsuario(String email, String password) {
        throw new UnsupportedOperationException("Unimplemented method 'validarUsuario'");
    }
}
