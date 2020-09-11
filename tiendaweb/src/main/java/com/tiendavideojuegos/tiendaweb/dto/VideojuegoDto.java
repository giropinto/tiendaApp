package com.tiendavideojuegos.tiendaweb.dto;
import lombok.Data;

@Data
public class VideojuegoDto {
    private String idvideojuego ;
	private String titulo;
	private Double precio ;
	private String fecha_lanzamiento;
    private String desarrolladora ;
    private String urlimg;
}
