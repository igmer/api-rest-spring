package com.admin.inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.inventario.models.Categoria;
import com.admin.inventario.models.Product;
import com.admin.inventario.models.SubCategoria;

public interface ProductoRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findBySubCategoria(SubCategoria idSubCategoria);
	
	List<Product> findBySubCategoriaCategoria(Categoria idCategoria);

}
