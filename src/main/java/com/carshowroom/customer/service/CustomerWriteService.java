package com.carshowroom.customer.service;

import com.carshowroom.customer.model.Customer;

public interface CustomerWriteService {
	Customer addCustomer(Customer customer);
	Customer updateCustomer(Customer customer, int id);
	boolean deleteCustomer(int id);
}
