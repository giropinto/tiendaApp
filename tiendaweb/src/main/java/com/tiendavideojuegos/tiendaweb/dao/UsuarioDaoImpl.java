package com.tiendavideojuegos.tiendaweb.dao;

import com.tiendavideojuegos.tiendaweb.dto.ResponsePayloadLogin;
import com.tiendavideojuegos.tiendaweb.dto.ResponsePayloadRegister;
import com.tiendavideojuegos.tiendaweb.dto.UsuarioRequest;
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
            while (resultado.next()){
                responsePayloadLogin.setEmail(resultado.getString("email"));
                responsePayloadLogin.setIdtoken("hrFDATxrG9w14QY9wwnmVhLE0Wg6LIvwOwUaxz761m1JfRp4rs8Mzozk5xhSkw0_MQz6bpcJnrFUDwp5lPPFC157dHxbkKlDiQ9XY3ZIP8zAGCsS8ruN2uKjIaIargX");
                responsePayloadLogin.setRefreshtoken("hrFDATxrG9w14QY9wwnmVhLE0Wg6LIvwOwUaxz761m1JfRp4rs8Mzozk5xhSkw0_MQz6bpcJnrFUDwp5lPPFC157dHxbkKlDiQ9XY3ZIP8zAGCsS8ruN2uKjIaIargX");
                responsePayloadLogin.setLocalid(resultado.getString("userid"));
                responsePayloadLogin.setExpiresIn("3600000");
                responsePayloadLogin.setRegistered(true);
            }
            cn.close();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return responsePayloadLogin;
    }
    public Integer buscarUsuarios() {
        String sql = "SELECT contrasenia, email, userid from usuario ";
        Integer ultimoindice = 0;
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                ultimoindice++;
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return ultimoindice;
    }
    public ResponsePayloadRegister registrarUsuario(UsuarioRequest usuarioRequest) {
        String sql = "insert into usuario values (?,?,?)";
        ResponsePayloadRegister responsePayloadRegister = new ResponsePayloadRegister();
        Integer newid = 10000 + buscarUsuarios();
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, String.valueOf(newid+1));
            ps.setString(2, usuarioRequest.getPassword());
            ps.setString(3, usuarioRequest.getEmail());
            ResultSet rs = ps.executeQuery();
            responsePayloadRegister.setEmail(usuarioRequest.getEmail());
            responsePayloadRegister.setIdtoken("hrFDATxrG9w14QY9wwnmVhLE0Wg6LIvwOwUaxz761m1JfRp4rs8Mzozk5xhSkw0_MQz6bpcJnrFUDwp5lPPFC157dHxbkKlDiQ9XY3ZIP8zAGCsS8ruN2uKjIaIargX");
            responsePayloadRegister.setRefreshtoken("hrFDATxrG9w14QY9wwnmVhLE0Wg6LIvwOwUaxz761m1JfRp4rs8Mzozk5xhSkw0_MQz6bpcJnrFUDwp5lPPFC157dHxbkKlDiQ9XY3ZIP8zAGCsS8ruN2uKjIaIargX");
            responsePayloadRegister.setLocalid(String.valueOf(newid+1));
            responsePayloadRegister.setExpiresIn("3600000");
            rs.close();
            cn.close();
        }catch (SQLException throwables){
            System.out.println("EMAIL_EXISTS");
        }
        return responsePayloadRegister;
    }
}