package com.tcs.jpa.join.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.jpa.join.model.CustomerEntity;
import com.tcs.jpa.join.model.OrderEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
	CustomerEntity findCustomerByCustomerId(int id);
	Set<OrderEntity>  findOrdersByCustomerId(int id);
}
