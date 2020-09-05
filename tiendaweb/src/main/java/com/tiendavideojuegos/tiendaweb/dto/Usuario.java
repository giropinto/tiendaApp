package com.tiendavideojuegos.tiendaweb.dto;

import lombok.Data;

@Data
public class Usuario {
    private String nombres;
    private String apellidos;
    private String username;
    private String contrasenia;
}
