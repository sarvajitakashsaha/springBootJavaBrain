package com.example.springboot.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/placeOrder")
	public ResponseEntity<Customer> placeOrder(@RequestBody OrderRequest request) {
		Customer customer = customerRepository.save(request.getCustomer());
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}

	@GetMapping("/findAllOrders")
	public List<Customer> findAllOrders() {
		return customerRepository.findAll();
	}

	@GetMapping("/getInfo")
	public List<OrderResponse> getJoinData() {
		return customerRepository.getJoinFormation();
	}
	@GetMapping("/getCustomer/{id}")
	public Optional<Customer> finById(@PathVariable("id") int id) {
		return customerRepository.findById(id);
	}
}
