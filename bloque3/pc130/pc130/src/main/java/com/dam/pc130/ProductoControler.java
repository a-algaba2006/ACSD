package com.dam.pc130;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController 
@RequestMapping("/productos")
public class ProductoControler {
    
    private final ProductoRepository productos;

    //Spring entrega aqui el repositorio (inyeccion de dependencias)
    public ProductoControler(ProductoRepository productos) {
        this.productos = productos;
    }

    @GetMapping 
    public List<Producto> todos() {
        return productos.findAll();
    }

    @GetMapping ("/caros")
    public List<Producto> caros(@RequestParam double min) {
        return productos.findByPrecioGreaterThan(min);
    }

    @GetMapping ("/buscar")
    public List<Producto> buscar(@RequestParam String texto) {
        return productos.findByNombreContaining(texto);
    }

    @GetMapping ("/categoria/{id}")
    public List<Producto> categoria(@PathVariable int id) {
        return productos.findByCategoriaId(id);
    }



}
