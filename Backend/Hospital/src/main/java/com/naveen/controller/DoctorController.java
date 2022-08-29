package com.naveen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.naveen.entity.Doctor;
import com.naveen.service.HospitalService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {
	
	@Autowired
    HospitalService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/doctors/doctor")
    public boolean addUser(@RequestBody Doctor doctor) {
        service.saveDoctorInformation(doctor);
        return true;

    }
	
	  @CrossOrigin(origins = "http://localhost:4200")
	    @GetMapping("doctors/doctor/{name}")
	    public MappingJacksonValue getDoctorInformation(@PathVariable String name) {
	        Doctor doctor = service.showDoctorInformation(name);
	        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "field","patient_count");

	        FilterProvider filters = new SimpleFilterProvider().addFilter("DoctorFilter", filter);

	        MappingJacksonValue mapping = new MappingJacksonValue(doctor);

	        mapping.setFilters(filters);

	        return mapping;
	    }
	
	 @CrossOrigin(origins = "http://localhost:4200")
	    @GetMapping("doctors/doc/{name}")
	    public Doctor getDoctorInfo(@PathVariable String name) {
	        Doctor doctor = service.showDoctorInformation(name);
	        return doctor;
	    }
	 
	 @CrossOrigin(origins = "http://localhost:4200")
	    @GetMapping("doctors")
	    public MappingJacksonValue getListOfDoctor() {
	        List<Doctor> doctors = service.getDoctors() ;
	        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");

	        FilterProvider filters = new SimpleFilterProvider().addFilter("DoctorFilter", filter);

	        MappingJacksonValue mapping = new MappingJacksonValue(doctors);

	        mapping.setFilters(filters);

	        return mapping;
	    }
	
	
	
	

}
