package com.tiendavideojuegos.tiendaweb.controller;

import java.util.List;

import com.tiendavideojuegos.tiendaweb.dto.RelacionTv;
import com.tiendavideojuegos.tiendaweb.dto.TiendaDto;
import com.tiendavideojuegos.tiendaweb.dto.VideojuegoDto;
import com.tiendavideojuegos.tiendaweb.service.RelacionTvService;
import com.tiendavideojuegos.tiendaweb.service.TiendaService;
import com.tiendavideojuegos.tiendaweb.service.VideojuegoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tienda")
public class TiendaController {
    @Autowired
    private RelacionTvService relacionTvService;
    @Autowired
    private VideojuegoService videojuegoService;
    @Autowired
    private TiendaService tiendaService;
   
    @GetMapping("/getAll")
    public List<VideojuegoDto> getAll(){
      return videojuegoService.getAll();
    }  
    @GetMapping("/getById/{id}")
    public List<RelacionTv> getById(@PathVariable("id") String id){
      return relacionTvService.getById(id);
    }
    @GetMapping("/getdaoAll")
    public List<TiendaDto> getdaoAll(){
        return tiendaService.getAll();
    }
    @GetMapping("/getdaoById/{id}")
    public List<TiendaDto> getdaoById(@PathVariable("id") String id){
        return tiendaService.getById(id);
    }
    @GetMapping("/getvideojuegoAll")
    public List<VideojuegoDto> getvideoAll(){
        return videojuegoService.getAll();
    }
    @GetMapping("/getvideojuegoById/{id}")
    public List<VideojuegoDto> getvideojuegoById(@PathVariable("id") String id){
        return videojuegoService.getById(id);
    }

}
