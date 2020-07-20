package com.tiendavideojuegos.tiendaweb.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tiendavideojuegos.tiendaweb.dto.RelacionTv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RelacionTvDaoImpl implements CrudDaoInterface<RelacionTv> {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<RelacionTv> getAll() {
        String sql = "SELECT idtienda, idvideojuego, urltv, precioNormal, precioOferta, DiaFinOferta FROM relaciontv";
        List<RelacionTv> lista = new ArrayList<RelacionTv>();
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            Statement sentencia = cn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            while(resultado.next()){
                RelacionTv relacionTv= new RelacionTv();
                relacionTv.setIDTienda(resultado.getString("idtienda"));
                relacionTv.setIDvideojuego(resultado.getString("idvideojuego"));
                relacionTv.setUrlTV(resultado.getString("urltv"));
                Date dateObj = resultado.getDate("DiaFinOferta");
                //Converting the Date object to String format
                String date = dateObj.toString();
                relacionTv.setDiaFinOferta(date);
                relacionTv.setPrecioNormal(resultado.getDouble("precioNormal"));
                relacionTv.setPrecioOferta(resultado.getDouble("precioOferta"));
                lista.add(relacionTv);
            }

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return lista;
    }

    public List<RelacionTv> getbyId(String id) {
        String sql = "SELECT idtienda, idvideojuego, urltv, precioNormal, precioOferta, DiaFinOferta " +
                "FROM relaciontv WHERE idvideojuego = "+id;
        List<RelacionTv> lista = new ArrayList<RelacionTv>();
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            Statement sentencia = cn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            while(resultado.next()){
                RelacionTv relacionTv= new RelacionTv();
                relacionTv.setIDTienda(resultado.getString("idtienda"));
                relacionTv.setIDvideojuego(resultado.getString("idvideojuego"));
                relacionTv.setUrlTV(resultado.getString("urltv"));
                Date dateObj = resultado.getDate("DiaFinOferta");
                //Converting the Date object to String format
                String date = dateObj.toString();
                relacionTv.setDiaFinOferta(date);
                relacionTv.setPrecioNormal(resultado.getDouble("precioNormal"));
                relacionTv.setPrecioOferta(resultado.getDouble("precioOferta"));
                lista.add(relacionTv);
            }

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return lista;
    }
    
    
}