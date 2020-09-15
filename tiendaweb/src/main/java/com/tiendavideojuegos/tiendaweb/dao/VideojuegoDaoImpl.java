package com.tiendavideojuegos.tiendaweb.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tiendavideojuegos.tiendaweb.dto.FilterDto;
import com.tiendavideojuegos.tiendaweb.dto.LGDto;
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

    public List<VideojuegoDto> FindWithFilter(FilterDto filterDto) {

        List<VideojuegoDto> listaVideojuego = new ArrayList<>();
        String genreString =" ";
        String languageString=" ";
        filterDto.getGenre().size();
        filterDto.getLanguage().size();
        int i;
        if(filterDto.getGenre().size()>0){
            genreString = genreString + " idgenero IN (";
            for(i=0;i<filterDto.getGenre().size()-1;i++){
                genreString =  genreString +" "+ filterDto.getGenre().get(i)+",";
            }
            genreString = genreString +" "+  filterDto.getGenre().get(i)+" )";
        }else{
            genreString = " TRUE ";
        }
        if(filterDto.getLanguage().size()>0){
            languageString = languageString + " idlenguaje IN (";
            for(i=0;i<filterDto.getLanguage().size()-1;i++){
                languageString = languageString + " " +filterDto.getLanguage().get(i)+",";
            }
            languageString = languageString +"  "+ filterDto.getLanguage().get(i)+" )";
        }else{
            languageString = " TRUE ";
        }

        String sql = " SELECT * From videojuego Where idvideojuego IN (SELECT idvideojuego FROM relaciongv WHERE "
                + genreString + " AND idvideojuego in (SELECT idvideojuego FROM relacionlv WHERE "
                + languageString+ " ));";

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

        VideojuegoDto videojuego1 = new VideojuegoDto();
        String sql = "SELECT idvideojuego, titulo, precio, fecha_lanzamiento, desarrolladora, urlimg FROM videojuego WHERE titulo = ? ";
        String sql2 = "UPDATE videojuego SET visitas = visitas+1  WHERE titulo = ?";
        
        try {
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, videojuegoDto.getTitulo());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                videojuego1.setDesarrolladora(rs.getString("desarrolladora"));
                videojuego1.setFecha_lanzamiento(rs.getString("fecha_lanzamiento"));
                videojuego1.setIdvideojuego(rs.getString("idvideojuego"));
                videojuego1.setPrecio(rs.getDouble("precio"));
                videojuego1.setTitulo(rs.getString("titulo"));
                videojuego1.setUrlimg(rs.getString("urlimg"));
            }
            Connection cn2 = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps2 = cn2.prepareStatement(sql2);
            ps2.setString(1, videojuegoDto.getTitulo());
            ps2.executeUpdate();    
            cn2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return videojuego1;
    }

    @Override
    public LGDto GetLG(VideojuegoDto videojuegoDto) {
       
        LGDto lgDto = new LGDto();
        List<String> genero= new ArrayList<>();
        List<String> lenguaje= new ArrayList<>();
        String sql1 = "SELECT nombre FROM generos WHERE idgenero IN (SELECT idgenero FROM relaciongv WHERE idvideojuego = ?);";
        String sql2 = "SELECT nombre FROM lenguajes WHERE idlenguaje IN (SELECT idlenguaje FROM relacionlv WHERE idvideojuego = ?)";
       
        try {
            Connection cn1 = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps1 = cn1.prepareStatement(sql1);
            ps1.setString(1, videojuegoDto.getIdvideojuego());
            ResultSet rs1 = ps1.executeQuery();
          
            while (rs1.next()) {
                genero.add(rs1.getString("nombre"));
            }
            lgDto.setGenero(genero);
            cn1.close();
            Connection cn2 = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps2 = cn2.prepareStatement(sql2);
            ps2.setString(1, videojuegoDto.getIdvideojuego());
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                lenguaje.add(rs2.getString("nombre"));
            }
            lgDto.setLenguaje(lenguaje);
            cn2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lgDto;
    }

}