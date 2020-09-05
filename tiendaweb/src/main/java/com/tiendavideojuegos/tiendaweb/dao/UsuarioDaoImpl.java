package com.tiendavideojuegos.tiendaweb.dao;

import com.tiendavideojuegos.tiendaweb.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsuarioDaoImpl implements CrudDaoInterface<Usuario>{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Usuario> getAll() {
        return null;
    }
    public List<Usuario> getbyId(String id) {
        return null;
    }

    public Usuario loginUsuario(Usuario usuario) {
        String sql = "SELECT username, contrasenia, nombres, apellidos from usuario where username = ? and contrasenia = ?";
        Usuario usuario1 = new Usuario();
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, usuario.getUsername());
            sentencia.setString(2,usuario.getContrasenia());
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                usuario1.setNombres(resultado.getString("nombres"));
                usuario1.setApellidos(resultado.getString("apellidos"));
                usuario1.setUsername(resultado.getString("username"));
                usuario1.setContrasenia(resultado.getString("contrasenia"));
            }
            cn.close();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return usuario1;
    }
}
