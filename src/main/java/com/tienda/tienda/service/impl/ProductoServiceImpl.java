
package com.tienda.tienda.service.impl;

import com.tienda.tienda.dao.ProductoDao;
import com.tienda.tienda.domain.Producto;
import com.tienda.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //Cuando trae @ a esto se le conoce como notacion
public class ProductoServiceImpl implements ProductoService{
    
    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true) //No altera la base de datos solo trae los datos
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)//No altera la base de datos solo trae los datos
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional //Si modifica la base de datos
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional //Si modifica la base de datos
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)//No altera la base de datos solo trae los datos
    public List<Producto> getByPrecio(double precioInf, double precioSup) {
        
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)//No altera la base de datos solo trae los datos
    public List<Producto> consultaJPQL(double precioInf, double precioSup) {
        return productoDao.consultaJPQL(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)//No altera la base de datos solo trae los datos
    public List<Producto> consultaNativo(double precioInf, double precioSup) {
        return productoDao.consultaNativo(precioInf, precioSup);
    }
    
    
    
    
    
    
    
}
