package com.tiendavideojuegos.tiendaweb.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tiendavideojuegos.tiendaweb.dto.VideojuegoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class VideojuegoDaoImpl implements CrudDaoInterface<VideojuegoDto> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VideojuegoDto> getAll() {

        String sql = "SELECT titulo,idvideojuego,urlimg FROM videojuegos";
        List<VideojuegoDto> lista = new ArrayList<VideojuegoDto>();
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            Statement sentencia = cn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            while(resultado.next()){
                VideojuegoDto videojuego= new VideojuegoDto();
                videojuego.setTitulo(resultado.getString("titulo"));
                videojuego.setIDvideojuego(resultado.getString("idvideojuego"));
                videojuego.setUrlimg(resultado.getString("urlimg"));
                lista.add(videojuego);
            }

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return lista;
    }

    public List<VideojuegoDto> getbyId(String id) {
       
        return null;
    }
    
}