package com.tiendavideojuegos.tiendaweb.controller;

import java.util.List;

import com.tiendavideojuegos.tiendaweb.dto.RelacionTv;
import com.tiendavideojuegos.tiendaweb.dto.TiendaDto;
import com.tiendavideojuegos.tiendaweb.dto.VideojuegoDto;
import com.tiendavideojuegos.tiendaweb.service.RelacionTvService;

import com.tiendavideojuegos.tiendaweb.service.TiendaDaoService;
import com.tiendavideojuegos.tiendaweb.service.VideojuegoDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200" )
@RestController
@RequestMapping("/tienda")
public class TiendaController {
    @Autowired
    private RelacionTvService relacionTvService;

    @Autowired
    private TiendaDaoService tiendaDaoService;

    @Autowired
    private VideojuegoDaoService videojuegoDaoService;
    //Cambiemoslo a post
    //@PostMapping(value = "/getRelacionTv",consumes = "application/json;charset=utf-8")
    @GetMapping("/getAll")
    public List<RelacionTv> getAll(){
      return relacionTvService.getAll(); 
    }  
    @GetMapping("/getById/{id}")
    public List<RelacionTv> getById(@PathVariable("id") String id){
      return relacionTvService.getById(id);
    }
    @GetMapping("/getdaoAll")
    public List<TiendaDto> getdaoAll(){
        return tiendaDaoService.getAll();
    }
    @GetMapping("/getdaoById/{id}")
    public List<TiendaDto> getdaoById(@PathVariable("id") String id){
        return tiendaDaoService.getById(id);
    }
    @GetMapping("/getvideojuegoAll")
    public List<VideojuegoDto> getvideoAll(){
        return videojuegoDaoService.getAll();
    }
    @GetMapping("/getvideojuegoById/{id}")
    public List<VideojuegoDto> getvideojuegoById(@PathVariable("id") String id){
        return videojuegoDaoService.getById(id);
    }

}