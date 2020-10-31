package com.admin.iventario.interfaces;

import java.util.List;

import org.springframework.http.HttpEntity;

import com.admin.inventario.models.Categoria;
import com.admin.inventario.models.Customer;
import com.admin.inventario.models.Product;
import com.admin.inventario.models.SubCategoria;

public interface ProductService {
	
	List<Product> searchAll();
	
	Product getById(int id);
	
	Product saveProduct(Product product);
	
	List<Product> getByIdCategoria(Categoria idCategoria);
	
	List<Product> getByIdSubCategoria(SubCategoria idSubCategoria);
	
	HttpEntity<String> insertBatchProduct(List<Product> listProducts);
	
	

}
