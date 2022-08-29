package com.naveen;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.naveen.repository.DoctorRepository;
import com.naveen.repository.PatientRepository;


@SpringBootTest
class HospitalApplicationTests {

	@Autowired
	DoctorRepository dRepo;
	
	@Autowired
	PatientRepository pRepo;
	
	
	@Test
	public void testByDoctorId() {
		assertNotNull(dRepo.findById(1).get());
		
	}
	
	@Test
	public void testByPatientId() {
		assertNotNull(pRepo.findById(2).get());
	}
	
	

}
