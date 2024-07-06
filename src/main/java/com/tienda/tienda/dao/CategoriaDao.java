
package com.tienda.tienda.dao;

import com.tienda.tienda.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

//Esta interface se encargara de comunicar con la BD
public interface CategoriaDao extends JpaRepository<Categoria, Long>{//En el primer object va la clase que se va a importar, el segundo el tipo de dato de la PK 
    
    
}
