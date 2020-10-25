package com.admin.inventario;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.admin.controller.ClienteController;
import com.admin.inventario.models.Categoria;
import com.admin.inventario.models.Customer;
import com.admin.inventario.models.Product;
import com.admin.inventario.models.SubCategoria;
import com.admin.inventario.repository.CategoriaRepository;
import com.admin.inventario.repository.ClienteRepository;
import com.admin.inventario.repository.ProductoRepository;
import com.admin.inventario.repository.SubCategoriaRepository;

@SpringBootApplication
@ComponentScan({"com.admin.controller"})
public class InventarioApplication {
	@Autowired
	private CategoriaRepository catRepository;
	@Autowired
	private SubCategoriaRepository subCatRepository;
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
	
		SpringApplication.run(InventarioApplication.class, args);
		
	}
	

}
