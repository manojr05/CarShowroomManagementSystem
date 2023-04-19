package com.carshowroom.bill.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carshowroom.bill.model.Bill;
import com.carshowroom.bill.repository.BillRepository;
import com.carshowroom.exception.ResourceNotFoundException;

@Service
public class BillReadServiceImpl implements BillReadService {

	private BillRepository billRepository;

	@Autowired
	public BillReadServiceImpl(BillRepository billRepository) {
		super();
		this.billRepository = billRepository;
	}

	@Override
	public List<Bill> getAllBill() {
		return billRepository.findAll();
	}

	@Override
	public Bill getBillById(int id) {
		Optional<Bill> findById = billRepository.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}else {
			throw new ResourceNotFoundException("Bill", "id", id);
		}
	}

}
