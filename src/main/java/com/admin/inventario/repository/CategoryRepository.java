package com.admin.inventario.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.admin.inventario.models.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
	

}
