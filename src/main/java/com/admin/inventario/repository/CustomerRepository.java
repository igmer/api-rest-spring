package com.admin.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.inventario.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
