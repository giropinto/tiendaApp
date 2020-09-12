package com.tiendavideojuegos.tiendaweb.dao;

import com.tiendavideojuegos.tiendaweb.dto.ResponsePayloadRegister;
import com.tiendavideojuegos.tiendaweb.dto.UsuarioRequest;
import com.tiendavideojuegos.tiendaweb.dto.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class UsuarioDaoImpl implements CrudDaoInterface<UsuarioRequest>{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<UsuarioRequest> getAll() {
        return null;
    }
    public List<UsuarioRequest> getbyId(String id) {
        return null;
    }

    public UsuarioResponse loginUsuario(UsuarioRequest usuarioRequest) {
        String sql = "SELECT contrasenia, email, userid from usuario where email = ? and contrasenia = ?";
        UsuarioResponse usuarioResponse1 = new UsuarioResponse();
        ResponsePayloadRegister responsePayloadRegister = new ResponsePayloadRegister();
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, usuarioRequest.getEmail());
            sentencia.setString(2, usuarioRequest.getContrasenia());
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                usuarioResponse1.setEmail(resultado.getString("email"));
                usuarioResponse1.setUserid(resultado.getString("userid"));
                usuarioResponse1.setContrasenia(resultado.getString("contrasenia"));
            }
            responsePayloadRegister.setEmail(usuarioResponse1.getEmail());
            responsePayloadRegister.setIdtoken("hrFDATxrG9w14QY9wwnmVhLE0Wg6LIvwOwUaxz761m1JfRp4rs8Mzozk5xhSkw0_MQz6bpcJnrFUDwp5lPPFC157dHxbkKlDiQ9XY3ZIP8zAGCsS8ruN2uKjIaIargX");
            responsePayloadRegister.setRefreshtoken("hrFDATxrG9w14QY9wwnmVhLE0Wg6LIvwOwUaxz761m1JfRp4rs8Mzozk5xhSkw0_MQz6bpcJnrFUDwp5lPPFC157dHxbkKlDiQ9XY3ZIP8zAGCsS8ruN2uKjIaIargX");
            responsePayloadRegister.setLocalid(usuarioResponse1.getUserid());
            responsePayloadRegister.setExpiresIn("3600000");
            cn.close();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return usuarioResponse1;
    }
    public Integer buscarUsuarios() {
        String sql = "SELECT contrasenia, email, userid from usuario ";
        Integer ultimoindice = 0;
        UsuarioResponse lastdata = new UsuarioResponse();
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                lastdata.setUserid(rs.getString("userid"));
                lastdata.setEmail(rs.getString("email"));
                lastdata.setContrasenia(rs.getString("contrasenia"));
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
            Connection cn1 = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, String.valueOf(newid+1));
            ps.setString(2, usuarioRequest.getContrasenia());
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
            throwables.printStackTrace();
        }
        return responsePayloadRegister;
    }
}
