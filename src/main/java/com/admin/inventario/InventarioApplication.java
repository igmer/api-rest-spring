package com.admin.inventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.admin.inventario.enums.RolName;
import com.admin.inventario.models.Rol;
import com.admin.inventario.repository.CategoryRepository;
import com.admin.inventario.repository.CustomerRepository;
import com.admin.inventario.repository.ProductRepository;
import com.admin.inventario.repository.RolRepository;
import com.admin.inventario.repository.SubCategoryRepository;
import com.admin.inventario.service.RolService;


@SpringBootApplication
public class InventarioApplication  {
	@Autowired
	private CategoryRepository catRepository;
	@Autowired
	private SubCategoryRepository subCatRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
    private RolRepository rolService;

	public static void main(String[] args) {
	
		SpringApplication.run(InventarioApplication.class, args);
		
	}


	
	

}
