package com.admin.inventario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.inventario.models.Customer;
import com.admin.inventario.repository.ClienteRepository;
import com.admin.iventario.interfaces.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class ClienteController implements CustomerService {
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/all")
	@Override
	public List<Customer> searchAll() {

		return clienteRepository.findAll();
	}

	@GetMapping("/customer/{id}")
	@Override
	public Customer getById(@PathVariable("id") int id) {
		Optional<Customer> customer = clienteRepository.findById(id);
		if (customer.isPresent()) {
			return customer.get();
		}
		return null;
	}

	@PostMapping("/customer")
	@Override
	public Customer saveCustomer(@RequestBody Customer customer) {
	
		clienteRepository.save(customer);
		return customer;

	}
	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody Customer customer) {	
		clienteRepository.save(customer);
		return customer;

	}

}
