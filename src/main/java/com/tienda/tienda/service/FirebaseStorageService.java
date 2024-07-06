
package com.tienda.tienda.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {
    
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String bucketName = "techshop-72b7e.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "techshop";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase"; //Que es el folder que se encuentra src/main/resources 
    
    //El nombre del archivo Json
    final String archivoJsonFile = "techshop-72b7e-firebase-adminsdk-44w4t-9393070aea.json"; //Importante ponerle la extension "json"
}
