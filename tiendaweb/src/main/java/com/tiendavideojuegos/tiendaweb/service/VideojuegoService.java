package com.tiendavideojuegos.tiendaweb.service;

import com.tiendavideojuegos.tiendaweb.dao.VideojuegoDaoImpl;
import com.tiendavideojuegos.tiendaweb.dto.VideojuegoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideojuegoService {
    @Autowired
    private VideojuegoDaoImpl videojuegoDao;
    public List<VideojuegoDto> getAll(){
        return videojuegoDao.getAll();
    }
    public List<VideojuegoDto> getById(String id){
        return videojuegoDao.getbyId(id);
    }
}
