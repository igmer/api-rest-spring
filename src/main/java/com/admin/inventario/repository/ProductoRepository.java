package com.admin.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.inventario.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
