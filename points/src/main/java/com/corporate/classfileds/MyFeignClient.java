package com.corporate.classfileds;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.corporate.classfileds.VO.Offer;

@FeignClient(value="offer")
public interface MyFeignClient {
	
	@GetMapping(value="/refreshingEmployeePointsAndSendingData/{empId}")
	public List<Offer> refreshingEmployeePointsAndSendingData(@PathVariable("empId") int empId);
}
