package com.tiendavideojuegos.tiendaweb.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tiendavideojuegos.tiendaweb.dto.FilterDto;
import com.tiendavideojuegos.tiendaweb.dto.VideojuegoDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class VideojuegoDaoImpl implements VideojuegoDao {

 
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VideojuegoDto> FindWithFilter(FilterDto filterDto){
        
        
        List<VideojuegoDto> listaVideojuego = new ArrayList<>();
        if(filterDto.getGenre()!=null){
           filterDto.setGenre(" idgenero = "+ filterDto.getGenre());   
        }else{
            filterDto.setGenre(" True ");
        }
        if(filterDto.getLanguage()!=null){
            filterDto.setLanguage(" idlenguaje = "+ filterDto.getLanguage()); 
        }else{
            filterDto.setLanguage(" True ");
        }
        if(filterDto.getPage()==null){

        }
        if(filterDto.getSearchAs()==null){}

        String sql  = " SELECT * From videojuego Where idvideojuego IN (SELECT idvideojuego FROM relaciongv WHERE "
        +filterDto.getGenre() + " AND idvideojuego in (SELECT idvideojuego FROM relacionlv WHERE " 
        +filterDto.getLanguage() + " ));";

         try {
             Connection connection = jdbcTemplate.getDataSource().getConnection();
            Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);
 
             while (resultSet.next()) {
                 VideojuegoDto videojuegoDto = new VideojuegoDto();
                videojuegoDto.setDesarrolladora(resultSet.getString("desarrolladora"));
                videojuegoDto.setFecha_lanzamiento(resultSet.getString("fecha_lanzamiento"));
                videojuegoDto.setIdvideojuego(resultSet.getString("idvideojuego"));
                videojuegoDto.setPrecio(resultSet.getDouble("precio"));
                videojuegoDto.setTitulo(resultSet.getString("titulo"));
                videojuegoDto.setUrlimg(resultSet.getString("urlimg"));
                 listaVideojuego.add(videojuegoDto);
             }

             connection.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return listaVideojuego;
     }

     @Override
     public VideojuegoDto FindByName(VideojuegoDto videojuegoDto) {
         // TODO Auto-generated method stub
         return null;
     }

}