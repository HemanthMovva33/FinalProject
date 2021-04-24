package com.corporate.classifieds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.corporate.classifieds.entity.Employee;
import com.corporate.classifieds.repository.EmployeeRepository;

@Component
public class EmployeeRunner implements CommandLineRunner {
	@Autowired
	EmployeeRepository empRepo;

	@Override
	public void run(String... args) throws Exception {
		Employee emp = new Employee();
		emp.setEmployeeid(120);
		emp.setFirstname("Nikhil");
		emp.setLastname("Manjunath");
		emp.setEmail("nik@gmail.com");
		
		empRepo.save(emp);
	}

}
