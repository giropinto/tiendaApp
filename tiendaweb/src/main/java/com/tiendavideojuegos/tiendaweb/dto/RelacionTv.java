package com.tiendavideojuegos.tiendaweb.dto;

import lombok.Data;

@Data
public class RelacionTv {
    String IDTienda;
	String IDvideojuego;
	String UrlTV;
	String DiaFinOferta;
	Double precioNormal;
	Double precioOferta;
}