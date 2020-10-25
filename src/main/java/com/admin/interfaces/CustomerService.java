package com.admin.interfaces;

import java.util.List;

import com.admin.inventario.models.Customer;

public interface CustomerService {
	
	List<Customer> searchAll();
	
	Customer getById(int id);
	// utilizado para actualizar y guardar (depende si lleva el campo id o no)
	Customer saveCustomer(Customer customer);
	
	
	

}
