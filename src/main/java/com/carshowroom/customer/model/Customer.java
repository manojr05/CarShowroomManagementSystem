package com.carshowroom.customer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer customerId;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "phone_no")
	private long phoneNo;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "employee_id")
	private int employeeId;
	
}
