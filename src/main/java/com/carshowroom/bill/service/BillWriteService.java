package com.carshowroom.bill.service;

import com.carshowroom.bill.model.Bill;

public interface BillWriteService {
	Bill addBill(Bill bill);
	Bill updateBill(Bill bill, int id);
	boolean deleteBill(int id);
}
