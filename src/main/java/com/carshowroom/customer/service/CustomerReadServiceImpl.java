package com.carshowroom.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carshowroom.customer.model.Customer;
import com.carshowroom.customer.repository.CustomerRepository;
import com.carshowroom.exception.ResourceNotFoundException;

@Service
public class CustomerReadServiceImpl implements CustomerReadService {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerReadServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getBillById(int id) {
		Optional<Customer> findById = customerRepository.findById(id);
		if (findById.isPresent())
			return findById.get();
		else
			throw new ResourceNotFoundException("Customer", "id", id);
	}

}
