package com.tiendavideojuegos.tiendaweb.dao;

import java.util.List;

import com.tiendavideojuegos.tiendaweb.dto.FilterDto;

import com.tiendavideojuegos.tiendaweb.dto.VideojuegoDto;

public interface VideojuegoDao {
    
    public abstract List<VideojuegoDto> FindWithFilter(FilterDto filterDto);

}
