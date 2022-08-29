package com.naveen.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naveen.entity.Doctor;
import com.naveen.entity.Patient;
import com.naveen.repository.DoctorRepository;
import com.naveen.repository.PatientRepository;
import com.naveen.service.HospitalService;

@Repository
@Transactional
public class HospitalServiceImpl implements HospitalService{

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;
    
	@Override
	public Doctor showDoctorInformation(String name) {
		 return doctorRepository.findByName(name);
	}
	@Override
	public Patient showPatientInformation(Integer Id) {
		return patientRepository.findById(Id).get();
	}
	@Override
	public boolean saveDoctorInformation(Doctor doctor) {
		doctorRepository.save(doctor);
        return true;
	}
	@Override                             
	public boolean savePatientInformation(Patient patient) {
		Doctor doctor = doctorRepository.findByName(patient.getDoctor_name());
        doctor.addPatients(patient);
        patientRepository.save(patient);
        doctor.setPatient_count();
        return true;
	}
	@Override
	public List<Patient> getPatientListOfDoctor(String name, Doctor doctor) {
		 return doctor.getPatients();
	}
	@Override
	public List<Doctor> getDoctors() {
		return (List<Doctor>) doctorRepository.findAll();
	}

}
