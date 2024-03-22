package com.doctorapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.IDoctorService;

@SpringBootApplication
public class SpringDoctorappJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDoctorappJdbcApplication.class, args);
	}

	@Autowired
	private IDoctorService doctorService;
	
	@Override
	public void run(String... args) throws Exception {
		List<Doctor> doctors = doctorService.getAll();
		for(Doctor doctor : doctors) {
			System.out.println(doctor);
		}
		System.out.println();
		System.out.println();
		
		doctors = doctorService.getBySpeciality("Ortho");
		for(Doctor doctor : doctors) {
			System.out.println(doctor);
		}
		System.out.println();
		System.out.println();
		
		Doctor doctor1 = doctorService.getById(3);
		System.out.println(doctor1);
		
		System.out.println();
		System.out.println();
		
		doctors = doctorService.getBySpecialityAndLessFees("Neurologist", 2100);
		for(Doctor doctor : doctors) {
			System.out.println(doctor);
		}
		System.out.println();
		System.out.println();
	}

}
