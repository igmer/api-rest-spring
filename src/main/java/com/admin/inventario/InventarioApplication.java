package com.admin.inventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.admin.inventario.enums.RolNombre;
import com.admin.inventario.models.Rol;
import com.admin.inventario.repository.CategoriaRepository;
import com.admin.inventario.repository.ClienteRepository;
import com.admin.inventario.repository.ProductoRepository;
import com.admin.inventario.repository.RolRepository;
import com.admin.inventario.repository.SubCategoriaRepository;
import com.admin.inventario.service.RolService;


@SpringBootApplication
public class InventarioApplication  {
	@Autowired
	private CategoriaRepository catRepository;
	@Autowired
	private SubCategoriaRepository subCatRepository;
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
    private RolRepository rolService;

	public static void main(String[] args) {
	
		SpringApplication.run(InventarioApplication.class, args);
		
	}


	
	

}
