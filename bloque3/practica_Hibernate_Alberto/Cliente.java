package com.dam.pc130;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity 
@Table (name = "CLIENTE")
public class Cliente {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    public Cliente(){

    }

    public Cliente (String nombre){
        this.nombre = nombre;
    }

    @ManyToMany 
    @JoinTable (name = "compra", // nombre de la relacion (tabla intermedia)
        joinColumns = @JoinColumn(name = "id_cliente"), // FK hacia cliente
        inverseJoinColumns = @JoinColumn (name = "id_producto") // FK hacia producto
    ) 
    private Set<Producto> productos = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
}
