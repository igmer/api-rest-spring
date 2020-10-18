package com.admin.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.inventario.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
