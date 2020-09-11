package com.tiendavideojuegos.tiendaweb.controller;


import com.tiendavideojuegos.tiendaweb.dto.FilterDto;
import com.tiendavideojuegos.tiendaweb.dto.ListaVideojuego;
import com.tiendavideojuegos.tiendaweb.service.VideojuegosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideojuegosController {
    @Autowired 
    private VideojuegosService videojuegosService;

    @RequestMapping(value = "/videojuegos",
                        method = RequestMethod.POST,
                        produces = "application/json;charset=utf-8")
        public @ResponseBody ListaVideojuego FindWithFilter(@RequestBody FilterDto filterDto){
            return videojuegosService.FindWithFilter(filterDto);
        }
}
