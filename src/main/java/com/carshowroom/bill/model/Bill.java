package com.carshowroom.bill.model;

import java.sql.Date;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.SQLInsert;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "bill")
@Data
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_number")
	private Integer billNumber;
	
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "price")
	private double price;
	
//	@Column(name = "gst")
//	@Formula("(price*0.28")
//	private double gst;
	
//	@Column(name = "total_price")
//	@Formula("price+gst")
//	private double totalPrice;
	
}
