package com.tiendavideojuegos.tiendaweb.dao;

import java.util.List;



public interface CrudDaoInterface<T> {
    
    public abstract List<T> getAll();
    public abstract List<T> getbyId(float num);
    
    
}