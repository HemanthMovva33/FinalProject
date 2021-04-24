//package com.corporate.classfileds;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.corporate.classfileds.entity.Points;
//import com.corporate.classfileds.repository.PointsRepository;
//
//
//
//@Component
//public class MyRunner implements CommandLineRunner {
//
//	@Autowired
//	PointsRepository pointsRepository;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		Points pt= new Points();
//		pt.setPointsOfEmployee(100);
//		pt.setEmployeeId(1);
//		//pt.setOfferId(1);
//		
//		pointsRepository.save(pt);
//	}
//}
