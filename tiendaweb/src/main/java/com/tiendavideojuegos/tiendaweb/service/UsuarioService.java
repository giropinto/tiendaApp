package com.tiendavideojuegos.tiendaweb.service;

import com.tiendavideojuegos.tiendaweb.dao.UsuarioDaoImpl;
import com.tiendavideojuegos.tiendaweb.dto.ResponsePayloadLogin;
import com.tiendavideojuegos.tiendaweb.dto.ResponsePayloadRegister;
import com.tiendavideojuegos.tiendaweb.dto.UsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioDaoImpl usuarioDao;
    
    public ResponsePayloadLogin loginUsuario(UsuarioRequest usuarioRequest) {
        return usuarioDao.loginUsuario(usuarioRequest);
    }
    public ResponsePayloadRegister registrarUsuario(UsuarioRequest usuarioRequest) { 
        return usuarioDao.registrarUsuario(usuarioRequest); }
}
