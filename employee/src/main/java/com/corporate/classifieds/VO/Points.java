package com.corporate.classifieds.VO;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class Points {
		
		private int employeeId;
		private int pointsOfEmployee;
		
		
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
