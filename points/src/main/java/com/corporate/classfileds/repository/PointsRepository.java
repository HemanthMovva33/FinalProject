package com.corporate.classfileds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corporate.classfileds.entity.Points;

@Repository
public interface PointsRepository extends JpaRepository<Points, Integer> {

	Points findAllByEmployeeId(int empId);

	

}
