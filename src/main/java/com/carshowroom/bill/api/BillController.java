package com.carshowroom.bill.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carshowroom.bill.model.Bill;
import com.carshowroom.bill.service.BillReadService;
import com.carshowroom.bill.service.BillWriteService;

@RestController
public class BillController {

	private BillWriteService billWriteService;
	private BillReadService billReadService;

	@Autowired
	public BillController(BillWriteService billWriteService, BillReadService billReadService) {
		super();
		this.billWriteService = billWriteService;
		this.billReadService = billReadService;
	}

	@GetMapping("/bill/{id}")
	public ResponseEntity<Bill> getBill(@PathVariable int id) {
		return new ResponseEntity<Bill>(billReadService.getBillById(id), HttpStatus.OK);
	}

	@GetMapping("/bills")
	public List<Bill> getAllBill() {
		return billReadService.getAllBill();
	}

	@PutMapping("/bill/{id}")
	public ResponseEntity<Bill> putBill(@RequestBody Bill bill, @PathVariable int id) {
		return new ResponseEntity<Bill>(billWriteService.updateBill(bill, id), HttpStatus.OK);
	}

	@PostMapping("/bill")
	public ResponseEntity<Bill> postBill(@RequestBody Bill bill) {
		return new ResponseEntity<Bill>(billWriteService.addBill(bill), HttpStatus.CREATED);
	}

	@DeleteMapping("/bill/{id}")
	public ResponseEntity<String> deleteBill(@PathVariable int id) {
		if(billWriteService.deleteBill(id))
			return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
		else
			return new ResponseEntity<String>("resource not found", HttpStatus.NOT_FOUND);
	}
}
