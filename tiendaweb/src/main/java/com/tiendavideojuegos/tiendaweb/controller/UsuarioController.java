package com.tiendavideojuegos.tiendaweb.controller;

import com.tiendavideojuegos.tiendaweb.dto.Usuario;
import com.tiendavideojuegos.tiendaweb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @RequestMapping(value = "/loginuser", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
    public Usuario loginUsuario(@RequestBody Usuario usuario){
        return usuarioService.loginUsuario(usuario);
    }
}
