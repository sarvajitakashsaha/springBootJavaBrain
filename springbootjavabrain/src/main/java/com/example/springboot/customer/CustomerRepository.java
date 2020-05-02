package com.example.springboot.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query("Select new com.example.springboot.customer.OrderResponse(c.name , p.productName) from Customer c join c.products p")
	public List<OrderResponse> getJoinFormation();
	
	@Query(value="SELECT * FROM CUSTOMER WHERE ID = ?1" , nativeQuery = true)
	public Customer getCustomerById(int id);
}
