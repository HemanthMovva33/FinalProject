package com.corporate.classifieds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.corporate.classifieds.VO.Offer;
import com.corporate.classifieds.VO.ResponseTemplateVo;
import com.corporate.classifieds.entity.Employee;
import com.corporate.classifieds.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping(value="/viewEmployeeOffers/{id}")
	public List<Offer> getEmployeeOffers(@PathVariable int id) {
		return empService.getEmployeeOffers(id);
	}
	
	@GetMapping(value="/viewMostLikedOffers/{id}")
	public List<Offer> getMostLikedOffers(@PathVariable int id) {
		return empService.getMostLikedOffers(id);
	}
	
	@GetMapping(value="/viewProfile/{empid}")
	public Employee getProfile(@PathVariable int empid) {
		return empService.getProfile(empid);
	}
	
}
