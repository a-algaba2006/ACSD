package com.dam.pc130;

import java.util.List;

// ClienteRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNombreContaining(String texto);        // WHERE nombre LIKE %texto%

}