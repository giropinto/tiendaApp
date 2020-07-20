package com.tiendavideojuegos.tiendaweb.service;

import com.tiendavideojuegos.tiendaweb.dao.TiendaDaoImpl;
import com.tiendavideojuegos.tiendaweb.dto.TiendaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiendaDaoService {
    @Autowired
    private TiendaDaoImpl tiendaDao;
    public List<TiendaDto> getAll() {
        return tiendaDao.getAll();
    }
    public List<TiendaDto> getById(String id){
        return tiendaDao.getbyId(id);
    }
}
