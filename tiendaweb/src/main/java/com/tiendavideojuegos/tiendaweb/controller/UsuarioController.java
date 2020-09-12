package com.tiendavideojuegos.tiendaweb.controller;

import com.tiendavideojuegos.tiendaweb.dto.ResponsePayloadLogin;
import com.tiendavideojuegos.tiendaweb.dto.ResponsePayloadRegister;
import com.tiendavideojuegos.tiendaweb.dto.UsuarioRequest;
import com.tiendavideojuegos.tiendaweb.exception.ApiRequestException;
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
    public ResponsePayloadLogin loginUsuario(@RequestBody UsuarioRequest usuarioRequest){
        throw new ApiRequestException("ok");
        //return usuarioService.loginUsuario(usuarioRequest);
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
    public ResponsePayloadRegister registrarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.registrarUsuario(usuarioRequest);
    }
}