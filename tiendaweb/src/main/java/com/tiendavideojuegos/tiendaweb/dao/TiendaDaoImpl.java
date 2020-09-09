package com.tiendavideojuegos.tiendaweb.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tiendavideojuegos.tiendaweb.dto.TiendaDto;
import com.tiendavideojuegos.tiendaweb.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TiendaDaoImpl implements CrudDaoInterface<TiendaDto> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TiendaDto> getAll() {
        List<TiendaDto> dtoList = new ArrayList<>();
        String sql = "SELECT nombretienda, idtienda FROM tienda";
        try {
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            Statement sentencia = cn.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);
            while (rs.next()) {
                TiendaDto tiendaDto = new TiendaDto();
                tiendaDto.setTiendaCodigo(rs.getString("idtienda"));
                tiendaDto.setTiendaNombre(rs.getNString("nombretienda"));
                dtoList.add(tiendaDto);
            }
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dtoList;
    }

    public List<TiendaDto> getbyId(String id) {
        List<TiendaDto> dtoList = new ArrayList<>();
        String sql = "SELECT nombretienda, idtienda FROM tienda where nombretienda = ?";
        try {
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, id);
            ResultSet rs = sentencia.executeQuery(sql);
            while (rs.next()) {
                TiendaDto tiendaDto = new TiendaDto();
                tiendaDto.setTiendaCodigo(rs.getString("idtienda"));
                tiendaDto.setTiendaNombre(rs.getNString("nombretienda"));
                dtoList.add(tiendaDto);
            }
            rs.close();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dtoList;
    }

    public Usuario loginUsuario(Usuario usuario) {
        return null;
    }
}
