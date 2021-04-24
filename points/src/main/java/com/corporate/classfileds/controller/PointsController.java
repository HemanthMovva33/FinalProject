package com.corporate.classfileds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corporate.classfileds.VO.ResponseTemplate;
import com.corporate.classfileds.entity.Points;
import com.corporate.classfileds.service.PointsService;

@RestController
public class PointsController {

	@Autowired
	private PointsService pointService;
	
	@GetMapping("/GetPointsOfEmployees/{empId}")
	public Points getPointsOfEmployee(@PathVariable("empId") int empId) {
		return pointService.getPointsOfEmployee(empId);
	}
	
	@GetMapping("/refreshPointsOfEmployee/{empId}")
	public Points refreshPointsOfEmployees(@PathVariable("empId") int empId) {
		return pointService.refreshPointsOfEmployee(empId);
	}
	
}
