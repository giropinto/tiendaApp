package com.tiendavideojuegos.tiendaweb.service;

import com.tiendavideojuegos.tiendaweb.dao.VideojuegoDao;
import com.tiendavideojuegos.tiendaweb.dto.FilterDto;
import com.tiendavideojuegos.tiendaweb.dto.IdArrayDto;
import com.tiendavideojuegos.tiendaweb.dto.LGDto;
import com.tiendavideojuegos.tiendaweb.dto.ListaVideojuego;
import com.tiendavideojuegos.tiendaweb.dto.VideojuegoDto;

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
    public VideojuegoDto FindByName(VideojuegoDto videojuegoDto){
        return videojuegoDao.FindByName(videojuegoDto);
    }
    public LGDto GetLG(VideojuegoDto videojuegoDto){
        return videojuegoDao.GetLG(videojuegoDto);
    }
    public ListaVideojuego TopGames(){
        ListaVideojuego listaVideojuego = new ListaVideojuego();
        listaVideojuego.setListaVideojuego(videojuegoDao.TopGames());
        return listaVideojuego;
    }
    public ListaVideojuego FindbyIds(IdArrayDto idArrayDto){
        ListaVideojuego listaVideojuego = new ListaVideojuego();
        listaVideojuego.setListaVideojuego(videojuegoDao.FindbyIds(idArrayDto));
        return listaVideojuego;
    }
    
}
