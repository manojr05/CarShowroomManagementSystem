package com.carshowroom.bill.service;

import java.util.List;
import java.util.Optional;

import com.carshowroom.bill.model.Bill;

public interface BillReadService {
	List<Bill> getAllBill();
	Bill getBillById(int id);
}
