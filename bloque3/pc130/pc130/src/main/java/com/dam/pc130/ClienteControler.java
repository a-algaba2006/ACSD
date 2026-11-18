package com.dam.pc130;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping ("/clientes")

public class ClienteControler {
    private final ClienteRepository clientes;

    public ClienteControler(ClienteRepository clientes) {
        this.clientes = clientes;
    }

    @GetMapping
    public List<Cliente> todos() {
        return clientes.findAll();
    }

    @GetMapping ("/buscar")
    public List<Cliente> buscar(@RequestParam String texto) {
        return clientes.findByNombreContaining(texto);
    }

}