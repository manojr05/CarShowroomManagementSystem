package com.carshowroom.customer.service;

import java.util.List;
import com.carshowroom.customer.model.Customer;

public interface CustomerReadService {
	List<Customer> getAllCustomer();
	Customer getBillById(int id);
}
