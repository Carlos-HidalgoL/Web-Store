package com.tienda.tienda.dao;

import com.tienda.tienda.domain.Categoria;
import com.tienda.tienda.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

//Esta interface se encargara de comunicar con la BD
public interface UsuarioDao extends JpaRepository<Usuario, Long> {//En el primer object va la clase que se va a importar, el segundo el tipo de dato de la PK 

    Usuario findByUsername(String username);

    Usuario findByUsernameAndPassword(String username, String Password);

    Usuario findByUsernameOrCorreo(String username, String correo);

    boolean existsByUsernameOrCorreo(String username, String correo);


}
