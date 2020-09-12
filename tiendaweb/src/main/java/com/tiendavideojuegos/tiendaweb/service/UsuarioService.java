package com.tiendavideojuegos.tiendaweb.service;

import com.tiendavideojuegos.tiendaweb.dao.UsuarioDaoImpl;
import com.tiendavideojuegos.tiendaweb.dto.ResponsePayloadRegister;
import com.tiendavideojuegos.tiendaweb.dto.UsuarioRequest;
import com.tiendavideojuegos.tiendaweb.dto.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioDaoImpl usuarioDao;
    public UsuarioResponse loginUsuario(UsuarioRequest usuarioRequest) {
        return usuarioDao.loginUsuario(usuarioRequest);
    }
    public ResponsePayloadRegister registrarUsuario(UsuarioRequest usuarioRequest) { return usuarioDao.registrarUsuario(usuarioRequest); }
}
