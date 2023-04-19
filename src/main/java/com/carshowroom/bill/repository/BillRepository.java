package com.carshowroom.bill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.carshowroom.bill.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

}
