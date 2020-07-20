package com.tiendavideojuegos.tiendaweb.service;


import java.util.List;

import com.tiendavideojuegos.tiendaweb.dao.RelacionTvDaoImpl;
import com.tiendavideojuegos.tiendaweb.dto.RelacionTv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelacionTvService {
    @Autowired
    private RelacionTvDaoImpl relacionTvdDaoImpl;

    public List<RelacionTv> getAll() {

      return relacionTvdDaoImpl.getAll();
        
    }
    public List<RelacionTv> getById(String id){
      return relacionTvdDaoImpl.getbyId(id);
    }
}