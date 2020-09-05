package com.tiendavideojuegos.tiendaweb.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tiendavideojuegos.tiendaweb.dto.Usuario;
import com.tiendavideojuegos.tiendaweb.dto.VideojuegoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class VideojuegoDaoImpl implements CrudDaoInterface<VideojuegoDto> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VideojuegoDto> getAll() {
        String sql = "SELECT titulo,idvideojuego,genero,urlimg FROM videojuegos";
        List<VideojuegoDto> lista = new ArrayList<VideojuegoDto>();
        try {
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            Statement sentencia = cn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                VideojuegoDto videojuego = new VideojuegoDto();
                videojuego.setTitulo(resultado.getString("titulo"));
                videojuego.setIDvideojuego(resultado.getString("idvideojuego"));
                videojuego.setGenero(resultado.getString("genero"));
                videojuego.setUrlimg(resultado.getString("urlimg"));
                lista.add(videojuego);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lista;
    }

    public List<VideojuegoDto> getbyId(String id) {
        String sql = "SELECT titulo,idvideojuego,genero,urlimg FROM videojuegos where idvideojuego=?";
        List<VideojuegoDto> lista = new ArrayList<VideojuegoDto>();
        try {
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                VideojuegoDto videojuego = new VideojuegoDto();
                videojuego.setTitulo(resultado.getString("titulo"));
                videojuego.setIDvideojuego(resultado.getString("idvideojuego"));
                videojuego.setGenero(resultado.getString("genero"));
                videojuego.setUrlimg(resultado.getString("urlimg"));
                lista.add(videojuego);
            }
            resultado.close();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lista;
    }

    public Usuario loginUsuario(Usuario usuario) {
        return null;
    }
}
