package com.tiendavideojuegos.tiendaweb.dao;

import com.tiendavideojuegos.tiendaweb.dto.Usuario;

import java.util.List;



public interface CrudDaoInterface<T> {
    public abstract List<T> getAll();
    public abstract List<T> getbyId(String id);
    public Usuario loginUsuario(Usuario usuario);
}
