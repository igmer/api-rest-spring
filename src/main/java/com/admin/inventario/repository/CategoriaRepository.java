package com.admin.inventario.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.admin.inventario.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
	

}
