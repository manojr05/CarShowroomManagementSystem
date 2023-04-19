package com.carshowroom.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carshowroom.customer.model.Customer;
import com.carshowroom.customer.repository.CustomerRepository;

@Service
public class CustomerWriteServiceImpl implements CustomerWriteService {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerWriteServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer, int id) {
		Customer c2 = customerRepository.findById(id).get();
		
		if(c2!=null) {
			c2.setAge(customer.getAge());
			c2.setCity(customer.getCity());
			c2.setCustomerName(customer.getCustomerName());
			c2.setEmployeeId(customer.getEmployeeId());
			c2.setPhoneNo(customer.getPhoneNo());
		}
		
		return customerRepository.save(c2);
		
	}

	@Override
	public boolean deleteCustomer(int id) {
		Customer customer = customerRepository.findById(id).get();
		
		if(customer!=null) {
			customerRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

}
