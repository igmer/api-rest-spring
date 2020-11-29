package com.admin.iventario.interfaces;

import java.util.List;

import org.springframework.http.HttpEntity;

import com.admin.inventario.models.Category;
import com.admin.inventario.models.Customer;
import com.admin.inventario.models.Product;
import com.admin.inventario.models.SubCategory;

public interface ProductService {
	
	List<Product> searchAll();
	
	Product getById(int id);
	
	Product saveProduct(Product product);
	
	List<Product> getByIdCategoria(Category idCategoria);
	
	List<Product> getByIdSubCategoria(SubCategory idSubCategoria);
	
	HttpEntity<String> insertBatchProduct(List<Product> listProducts);
	
	

}
