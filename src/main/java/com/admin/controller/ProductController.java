package com.admin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.admin.interfaces.ProductService;
import com.admin.inventario.models.Categoria;
import com.admin.inventario.models.Customer;
import com.admin.inventario.models.Product;
import com.admin.inventario.models.SubCategoria;
import com.admin.inventario.repository.ProductoRepository;

@RestController
@RequestMapping("/api/products")

public class ProductController implements ProductService {
	@Autowired
	ProductoRepository productRepository;

	@GetMapping("/all")
	@Override
	public List<Product> searchAll() {
		return productRepository.findAll();
	}

	@GetMapping("/product/{id}")
	@Override
	public Product getById(@PathVariable("id") int id) {

		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			return product.get();
		}
		return null;
	}

	@PostMapping("/product")
	@Override
	public Product saveProduct(@RequestBody Product product) {
		productRepository.save(product);
		return product;
	}

	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		productRepository.save(product);
		return product;
	}

	@GetMapping("/productos/by-categories/{id}")
	@Override
	public List<Product> getByIdCategoria(@PathVariable("id") Categoria idCategoria) {
		List<Product> listProdut = productRepository.findBySubCategoriaCategoria(idCategoria);
		return listProdut;

	}

	@GetMapping("/productos/by-sub-categories/{id}")
	@Override
	public List<Product> getByIdSubCategoria(@PathVariable("id") SubCategoria idSubCategoria) {
		List<Product> listProdut = productRepository.findBySubCategoria(idSubCategoria);
		return listProdut;
	}

	@PostMapping("/product/batch-insert")
	@Override
	public HttpEntity<String> insertBatchProduct(@RequestBody List<Product> listProducts) {
		try {

			productRepository.saveAll(listProducts);
			return ResponseEntity.ok("success");
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();

		}

	}

}
