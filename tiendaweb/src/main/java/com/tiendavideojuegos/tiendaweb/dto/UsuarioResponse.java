package com.tiendavideojuegos.tiendaweb.dto;

import lombok.Data;

@Data
public class UsuarioResponse {
    private String userid;
    private String email;
    private String contrasenia;
}
