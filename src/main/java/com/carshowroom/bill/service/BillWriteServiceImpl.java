package com.carshowroom.bill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carshowroom.bill.model.Bill;
import com.carshowroom.bill.repository.BillRepository;

@Service
public class BillWriteServiceImpl implements BillWriteService {

	private BillRepository billRepository;

	@Autowired
	public BillWriteServiceImpl(BillRepository billRepository) {
		super();
		this.billRepository = billRepository;
	}

	@Override
	public Bill addBill(Bill bill) {
		return billRepository.save(bill);
	}

	@Override
	public Bill updateBill(Bill bill, int id) {
		Bill b2 = billRepository.findById(id).get();

		if (b2 != null) {
			b2.setCustomerId(bill.getCustomerId());
			b2.setDate(bill.getDate());
			b2.setPrice(bill.getPrice());
		}

		billRepository.save(b2);

		return b2;
	}

	@Override
	public boolean deleteBill(int id) {
		Bill bill = billRepository.findById(id).get();
		
		if(bill!=null) {
			billRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

}
