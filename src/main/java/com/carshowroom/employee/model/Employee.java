package com.carshowroom.employee.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name="employee")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "doj")
	private Date doj;
	
	@Column(name = "job_role")
	private String jobRole;
	
	@Column(name = "salary")
	private double salary;

	@Column(name = "dl_number")
	private String dlNumber;

	@Column(name = "is_admin")
	private boolean isAdmin;
	
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin=isAdmin;
	}
	
	public boolean getIsAdmin() {
		return this.isAdmin;
	}
}
