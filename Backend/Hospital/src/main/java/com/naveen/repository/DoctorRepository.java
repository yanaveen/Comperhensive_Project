package com.naveen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naveen.entity.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer > {
	public Doctor findByName(String name);
}
