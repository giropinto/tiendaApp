package com.tiendavideojuegos.tiendaweb.dao;

import com.tiendavideojuegos.tiendaweb.dto.ResponsePayloadRegister;
import com.tiendavideojuegos.tiendaweb.dto.UsuarioRequest;
import com.tiendavideojuegos.tiendaweb.dto.UsuarioResponse;

import java.util.List;



public interface CrudDaoInterface<T> {
    public abstract List<T> getAll();
    public abstract List<T> getbyId(String id);
    public UsuarioResponse loginUsuario(UsuarioRequest usuarioRequest);
    public ResponsePayloadRegister registrarUsuario(UsuarioRequest usuarioRequest);
}
