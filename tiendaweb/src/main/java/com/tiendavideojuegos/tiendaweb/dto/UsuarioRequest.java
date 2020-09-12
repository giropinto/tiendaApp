package com.tiendavideojuegos.tiendaweb.dto;

import lombok.Data;

@Data
public class UsuarioRequest {
    private String email;
    private String password;
    private Boolean returnSecureToken;
}