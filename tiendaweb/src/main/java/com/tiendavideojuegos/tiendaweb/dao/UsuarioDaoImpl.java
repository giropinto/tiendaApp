package com.tiendavideojuegos.tiendaweb.dao;

import com.tiendavideojuegos.tiendaweb.dto.ResponsePayloadLogin;
import com.tiendavideojuegos.tiendaweb.dto.ResponsePayloadRegister;
import com.tiendavideojuegos.tiendaweb.dto.UsuarioRequest;
import com.tiendavideojuegos.tiendaweb.exception.ApiRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UsuarioDaoImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ResponsePayloadLogin loginUsuario(UsuarioRequest usuarioRequest) {
        String sql = "SELECT email, userid from usuario where email = ? and contrasenia = ?";
        ResponsePayloadLogin responsePayloadLogin = new ResponsePayloadLogin();
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, usuarioRequest.getEmail());
            sentencia.setString(2, usuarioRequest.getPassword());
            ResultSet resultado = sentencia.executeQuery();
            int i = 0;
            while (resultado.next()){
                responsePayloadLogin.setEmail(resultado.getString("email"));
                responsePayloadLogin.setIdToken("hrFDATxrG9w14QY9wwnmVhLE0Wg6LIvwOwUaxz761m1JfRp4rs8Mzozk5xhSkw0_MQz6bpcJnrFUDwp5lPPFC157dHxbkKlDiQ9XY3ZIP8zAGCsS8ruN2uKjIaIargX");
                responsePayloadLogin.setRefreshtoken("hrFDATxrG9w14QY9wwnmVhLE0Wg6LIvwOwUaxz761m1JfRp4rs8Mzozk5xhSkw0_MQz6bpcJnrFUDwp5lPPFC157dHxbkKlDiQ9XY3ZIP8zAGCsS8ruN2uKjIaIargX");
                responsePayloadLogin.setLocalId(resultado.getString("userid"));
                responsePayloadLogin.setExpiresIn("36000");
                responsePayloadLogin.setRegistered(true);
                i = 1;
            }
            cn.close();
            if(i==0){
                throw new SQLException("");
            }
        }catch (SQLException throwables){
            throw new ApiRequestException("EMAIL_NOT_FOUND");
        }
        return responsePayloadLogin;
    }

    public ResponsePayloadRegister registrarUsuario(UsuarioRequest usuarioRequest) {
        
        String sql = "insert into usuario(contrasenia,email) values (?,?)";
        String sql2 = "SELECT email, userid from usuario where email = ? and contrasenia = ?";
        ResponsePayloadRegister responsePayloadRegister = new ResponsePayloadRegister();
        
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, usuarioRequest.getPassword());
            ps.setString(2, usuarioRequest.getEmail());
            ResultSet rs = ps.executeQuery();
            
            rs.close();
            cn.close();
            
            Connection cn2 = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps2 = cn2.prepareStatement(sql2);
            ps2.setString(2, usuarioRequest.getPassword());
            ps2.setString(1, usuarioRequest.getEmail());
            ResultSet rs2 = ps2.executeQuery();

            while(rs2.next()){
            responsePayloadRegister.setEmail(rs2.getString("email"));
            responsePayloadRegister.setIdtoken("hrFDATxrG9w14QY9wwnmVhLE0Wg6LIvwOwUaxz761m1JfRp4rs8Mzozk5xhSkw0_MQz6bpcJnrFUDwp5lPPFC157dHxbkKlDiQ9XY3ZIP8zAGCsS8ruN2uKjIaIargX");
            responsePayloadRegister.setRefreshtoken("hrFDATxrG9w14QY9wwnmVhLE0Wg6LIvwOwUaxz761m1JfRp4rs8Mzozk5xhSkw0_MQz6bpcJnrFUDwp5lPPFC157dHxbkKlDiQ9XY3ZIP8zAGCsS8ruN2uKjIaIargX");
            responsePayloadRegister.setLocalId(rs2.getString("userid"));
            responsePayloadRegister.setExpiresIn("36000");
            }
            
        }catch (SQLException throwables){
            throw new ApiRequestException("EMAIL_EXISTS");
        }
        return responsePayloadRegister;
    }
}