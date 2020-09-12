package com.tiendavideojuegos.tiendaweb.service;


import com.tiendavideojuegos.tiendaweb.dao.VideojuegoDao;
import com.tiendavideojuegos.tiendaweb.dto.FilterDto;
import com.tiendavideojuegos.tiendaweb.dto.ListaVideojuego;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideojuegosService {
    @Autowired
    private VideojuegoDao videojuegoDao;
    public ListaVideojuego FindWithFilter(FilterDto filterDto){
        ListaVideojuego listaVideojuego = new ListaVideojuego();
        listaVideojuego.setListaVideojuego(videojuegoDao.FindWithFilter(filterDto));
        return listaVideojuego;

    }   
}