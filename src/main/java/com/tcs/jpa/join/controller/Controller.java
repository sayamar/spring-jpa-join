package com.tcs.jpa.join.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.jpa.join.model.CustomerEntity;
import com.tcs.jpa.join.model.OrderEntity;
import com.tcs.jpa.join.repository.CustomerRepository;

@RestController
@RequestMapping("orders")
public class Controller {
	
	private final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
	
	private final CustomerRepository repository;
	
	public Controller(CustomerRepository repository) {
		this.repository = repository;
	}

	@GetMapping("{id}")
	public ResponseEntity<Set<OrderEntity>> getOrdersForCustomer(@PathVariable int id) {
		CustomerEntity customerEntity = repository.findCustomerByCustomerId(id);
		
		Set<OrderEntity> ordersData= customerEntity.getOrdersList();
		return new ResponseEntity<Set<OrderEntity>>(ordersData, HttpStatus.OK);
	}
}