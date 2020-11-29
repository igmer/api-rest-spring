package com.admin.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.inventario.models.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
	

}
