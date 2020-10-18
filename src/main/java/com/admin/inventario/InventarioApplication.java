package com.admin.inventario;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.admin.inventario.models.Categoria;
import com.admin.inventario.models.Cliente;
import com.admin.inventario.models.Producto;
import com.admin.inventario.models.SubCategoria;
import com.admin.inventario.repository.CategoriaRepository;
import com.admin.inventario.repository.ClienteRepository;
import com.admin.inventario.repository.ProductoRepository;
import com.admin.inventario.repository.SubCategoriaRepository;

@SpringBootApplication
public class InventarioApplication implements CommandLineRunner{
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
	@Override
	public void run(String... args) throws Exception {
		System.out.print("guardando");
		guardarSUB();
		
	}
	public void guardar() {
		Categoria cat = new Categoria();
		cat.setNombre("Lacteos");
		cat.setDescripcion("Derivados de leche");
		catRepository.save(cat);
		System.out.print("se guardo");
	}
	public void guardarSUB() {
		Cliente clie = new Cliente();
		clie.setApellido("rodriguez");
		clie.setNombre("igmer");
		clie.setComentario("prueba");
		clie.setDireecion("comasagua");
		clie.setEmail("igmerdz@gmail.com");
		clie.setTelefono1("77486504");	
		
		
		clienteRepository.save(clie);
		System.out.print("se guardo pro");
	}
	

}
