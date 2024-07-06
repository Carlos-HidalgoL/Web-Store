
package com.tienda.tienda.service.impl;

import com.tienda.tienda.dao.CategoriaDao;
import com.tienda.tienda.dao.ProductoDao;
import com.tienda.tienda.domain.Categoria;
import com.tienda.tienda.domain.Producto;
import com.tienda.tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //Cuando trae @ a esto se le conoce como notacion
public class CategoriaServiceImpl implements CategoriaService{
    
   @Autowired
    private CategoriaDao categoriaDao;
   

    @Override
    @Transactional(readOnly = true) //No altera la base de datos solo trae los datos
    public List<Categoria> getCategorias(boolean activos) {
        var lista = categoriaDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)//No altera la base de datos solo trae los datos
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional //Si modifica la base de datos
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional //Si modifica la base de datos
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
    
    
}
