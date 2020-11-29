package com.admin.inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.inventario.models.Category;
import com.admin.inventario.models.Product;
import com.admin.inventario.models.SubCategory;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findBySubCategory(SubCategory idSubCategory);
	
	List<Product> findBySubCategory(Category idCategy);

}
