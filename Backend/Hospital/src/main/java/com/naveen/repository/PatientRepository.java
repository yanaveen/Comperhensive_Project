package com.naveen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naveen.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
	

}
