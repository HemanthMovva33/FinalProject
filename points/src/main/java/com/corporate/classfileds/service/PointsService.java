package com.corporate.classfileds.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.corporate.classfileds.MyFeignClient;
import com.corporate.classfileds.VO.Employee;
import com.corporate.classfileds.VO.Offer;
import com.corporate.classfileds.VO.ResponseTemplate;
import com.corporate.classfileds.entity.Points;
import com.corporate.classfileds.repository.PointsRepository;

@Service
public class PointsService {

	@Autowired
	private PointsRepository pointsRepository;

//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private MyFeignClient myFeignClient;
	
	ResponseTemplate vo = new ResponseTemplate();

	public Points getPointsOfEmployee(int empId) {
		return pointsRepository.findAllByEmployeeId(empId);
	}

	public Points refreshPointsOfEmployee(int empId) {

		//ResponseEntity<Offer[]> rs = restTemplate
		//		.getForEntity("http://localhost:8080/refreshingEmployeePointsAndSendingData/" + empId, Offer[].class);
		
		List<Offer> offer =myFeignClient.refreshingEmployeePointsAndSendingData(empId);
		System.out.println(offer);
		//Offer offer[] = rs.getBody();
		//List<Offer> offers = Arrays.asList(offer);

		int points = 0;

		for (Offer off : offer) {
			int points1 = 0;
			if (off.getOfferLikesInTwoDays() >= 50 && off.getOfferLikesInTwoDays() < 100) {
				points1 = points1 + 110;
			} else if (off.getOfferLikesInTwoDays() >= 100) {
				points1 = points1 + 120;
			} else if (off.getOfferLikesInTwoDays() < 50 && off.getOfferLikesInTwoDays() > 0) {
				points1 = points1 + 100;
			} else {
				points1 = points1;
			}

			points = points + points1;
		}
		Points point = new Points();
		point.setEmployeeId(empId);
		point.setPointsOfEmployee(points);
		return pointsRepository.save(point);
		//return points;

	}

}
