package com.corporate.classfileds.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Points {
	
	
	@Id
	private int employeeId;
	private int pointsOfEmployee;
	//private int offerId;
	
	
	public int getPointsOfEmployee() {
		return pointsOfEmployee;
	}
	public void setPointsOfEmployee(int pointsOfEmployee) {
		this.pointsOfEmployee = pointsOfEmployee;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
	
}
