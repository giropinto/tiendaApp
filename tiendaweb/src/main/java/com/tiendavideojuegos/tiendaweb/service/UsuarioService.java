package com.tiendavideojuegos.tiendaweb.service;

import com.tiendavideojuegos.tiendaweb.dao.CrudDaoInterface;
import com.tiendavideojuegos.tiendaweb.dao.UsuarioDaoImpl;
import com.tiendavideojuegos.tiendaweb.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioDaoImpl usuarioDao;
    public Usuario loginUsuario(Usuario usuario) {
        return usuarioDao.loginUsuario(usuario);
    }
}
