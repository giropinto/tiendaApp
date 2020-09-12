package com.tiendavideojuegos.tiendaweb.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tiendavideojuegos.tiendaweb.dto.RelacionTv;

import com.tiendavideojuegos.tiendaweb.dto.ResponsePayloadRegister;
import com.tiendavideojuegos.tiendaweb.dto.UsuarioRequest;
import com.tiendavideojuegos.tiendaweb.dto.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RelacionTvDaoImpl implements CrudDaoInterface<RelacionTv>{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<RelacionTv> getAll() {
        final String sql = "SELECT idtienda, idvideojuego, urltv, precioNormal, precioOferta, DiaFinOferta FROM relaciontv";
        final List<RelacionTv> lista = new ArrayList<RelacionTv>();
        try{
            final Connection cn = jdbcTemplate.getDataSource().getConnection();
            final Statement sentencia = cn.createStatement();
            final ResultSet resultado = sentencia.executeQuery(sql);
            while(resultado.next()){
                final RelacionTv relacionTv= new RelacionTv();
                relacionTv.setIDTienda(resultado.getString("idtienda"));
                relacionTv.setIDvideojuego(resultado.getString("idvideojuego"));
                relacionTv.setUrlTV(resultado.getString("urltv"));
                final Date dateObj = resultado.getDate("DiaFinOferta");
                //Converting the Date object to String format
                final String date = dateObj.toString();
                relacionTv.setDiaFinOferta(date);
                relacionTv.setPrecioNormal(resultado.getDouble("precioNormal"));
                relacionTv.setPrecioOferta(resultado.getDouble("precioOferta"));
                lista.add(relacionTv);
            }
            resultado.close();
            cn.close();
        }catch (final SQLException throwables){
            throwables.printStackTrace();
        }
        return lista;
    }

    public List<RelacionTv> getbyId(final String id) {
        final String sql = "SELECT idtienda, idvideojuego, urltv, precioNormal, precioOferta, DiaFinOferta " +
                "FROM relaciontv WHERE idvideojuego = ?";
        final List<RelacionTv> lista = new ArrayList<RelacionTv>();
        try{
            final Connection cn = jdbcTemplate.getDataSource().getConnection();
            final PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, id);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                final RelacionTv relacionTv1= new RelacionTv();
                relacionTv1.setIDTienda(resultado.getString("idtienda"));
                relacionTv1.setIDvideojuego(resultado.getString("idvideojuego"));
                relacionTv1.setUrlTV(resultado.getString("urltv"));
                final Date dateObj = resultado.getDate("DiaFinOferta");
                //Converting the Date object to String format
                final String date = dateObj.toString();
                relacionTv1.setDiaFinOferta(date);
                relacionTv1.setPrecioNormal(resultado.getDouble("precioNormal"));
                relacionTv1.setPrecioOferta(resultado.getDouble("precioOferta"));
                lista.add(relacionTv1);
            }
            resultado.close();
            cn.close();
        }catch (final SQLException throwables){
            throwables.printStackTrace();
        }
        return lista;
    }

    public UsuarioResponse loginUsuario(UsuarioRequest usuarioRequest) {
        return null;
    }

    public ResponsePayloadRegister registrarUsuario(UsuarioRequest usuarioRequest) {return null;}

    public List<RelacionTv> getbyName(RelacionTv relacionTv){return null;}
    
}
