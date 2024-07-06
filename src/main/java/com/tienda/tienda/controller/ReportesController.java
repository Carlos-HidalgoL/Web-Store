package com.tienda.tienda.controller;

import com.tienda.tienda.service.ReportesService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j //Navegaciones
@RequestMapping("/reportes")
public class ReportesController {

    @Autowired //Sirve para crear autoinstancias
    private ReportesService reporteService;

    @GetMapping("/principal")
    public String listado(Model model) {

        return "/reportes/principal";

    }

    @GetMapping("/usuarios")
    public ResponseEntity<Resource> ReporteUsuarios(@RequestParam String tipo) throws IOException {
        var reporte = "usuarios";
        return reporteService.generarReporte(reporte, null, tipo);

    }

    @GetMapping("/categorias")
    public ResponseEntity<Resource> ReporteCategorias(@RequestParam String tipo) throws IOException {
        var reporte = "categorias";
        return reporteService.generarReporte(reporte, null, tipo);

    }

    @GetMapping("/productos")
    public ResponseEntity<Resource> ReporteProductos(@RequestParam String tipo) throws IOException {
        var reporte = "productos";
        
        Double precioMinimo = 10000.00;
        Double precioMaximo = 25000.00;
        
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("precioMinimo", precioMinimo);
        parametros.put("precioMaximo", precioMaximo);

        return reporteService.generarReporte(reporte, parametros, tipo);
        

    }

}
