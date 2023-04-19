package com.carshowroom.customer.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.carshowroom.customer.model.Customer;
import com.carshowroom.customer.service.CustomerReadService;
import com.carshowroom.customer.service.CustomerWriteService;

@RestController
public class CustomerController {

	private CustomerWriteService customerWriteService;
	private CustomerReadService customerReadService;

	@Autowired
	public CustomerController(CustomerWriteService customerWriteService, CustomerReadService customerReadService) {
		super();
		this.customerWriteService = customerWriteService;
		this.customerReadService = customerReadService;
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
		return new ResponseEntity<Customer>(customerReadService.getBillById(id), HttpStatus.OK);
	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomer() {
		return customerReadService.getAllCustomer();
	}

	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> putCustomer(@RequestBody Customer customer, @PathVariable int id) {
		return new ResponseEntity<Customer>(customerWriteService.updateCustomer(customer, id), HttpStatus.OK);
	}

	@PostMapping("/customer")
	public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerWriteService.addCustomer(customer), HttpStatus.CREATED);
	}

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
		if (customerWriteService.deleteCustomer(id))
			return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
		else
			return new ResponseEntity<String>("resource not found", HttpStatus.NOT_FOUND);
	}

}
