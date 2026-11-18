package com.dam.pc130;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping ("/categorias")

public class CategoriaControler {
    private final CategoriaRepository categorias;

    public CategoriaControler(CategoriaRepository categorias) {
        this.categorias = categorias;
    }

    @GetMapping
    public List<Categoria> todas() {
        return categorias.findAll();
    }
}
