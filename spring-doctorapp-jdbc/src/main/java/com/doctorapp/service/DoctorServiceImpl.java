package com.doctorapp.service;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.exception.IdNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.repository.DoctorRepositoryImpl;
import com.doctorapp.repository.IDoctorRepository;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements IDoctorService {
    @Autowired
    private IDoctorRepository doctorRepository;
    
    public void addDoctor(Doctor doctor) {
        doctorRepository.addDoctor(doctor);
    }

    public void updateDoctor(int doctorId, double fees) {
        doctorRepository.updateDoctor(doctorId,fees);
    }

    public void deleteDoctor(int doctorId) {
        doctorRepository.deleteDoctor(doctorId);
    }

    public Doctor getById(int doctorId) throws IdNotFoundException {
        Doctor doctor = doctorRepository.findById(doctorId);
        if(doctor==null){
            throw new IdNotFoundException("Invalid ID");
        }
        return doctor;
    }

    public List<Doctor> getAll() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors;
    }

    public List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException {
        List<Doctor> doctorList = doctorRepository.findBySpeciality(speciality);
        if(doctorList.isEmpty()){
            throw new DoctorNotFoundException("Doctor not found with this speciality");
        }
        Collections.sort(doctorList,(d1,d2)->(d2.getSpeciality()).compareTo(d1.getSpeciality()));
        return doctorList;
    }

    public List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException {
        List<Doctor> doctorList = doctorRepository.findBySpecialityAndExp(speciality,experience);
        if(doctorList.isEmpty()){
            throw new DoctorNotFoundException("Doctor not found with this speciality and experience");
        }
        Collections.sort(doctorList,(d1,d2)->((Integer) d2.getExperience()).compareTo(d1.getExperience()));
        return doctorList;
    }

    public List<Doctor> getBySpecialityAndLessFees(String speciality, double fees) throws DoctorNotFoundException {
        List<Doctor> doctorList = doctorRepository.findBySpecialityAndLessFees(speciality,fees);
        if(doctorList.isEmpty()){
            throw new DoctorNotFoundException("Doctor not found with this speciality and less fess");
        }
        Collections.sort(doctorList,(d1,d2)->((Double)d2.getFees()).compareTo(d1.getFees()));
        return doctorList;
    }

    public List<Doctor> getBySpecialityAndRatings(String speciality, int ratings) throws DoctorNotFoundException {
        List<Doctor> doctorList = doctorRepository.findBySpecialityAndRatings(speciality,ratings);
        if(doctorList.isEmpty()){
            throw new DoctorNotFoundException("Doctor not found with this speciality and ratings");
        }
        Collections.sort(doctorList,(d1,d2)->((Integer)d2.getRatings()).compareTo(d1.getRatings()));
        return doctorList;
    }

    public List<Doctor> getBySpecialityAndNameContains(String speciality, String doctorName) throws DoctorNotFoundException {
        List<Doctor> doctorList = doctorRepository.findBySpecialityAndNameContains(speciality,doctorName);
        if(doctorList.isEmpty()){
            throw new DoctorNotFoundException("Doctor not found with this speciality and name");
        }
        Collections.sort(doctorList,(d1,d2)->(d2.getDoctorName()).compareTo(d1.getDoctorName()));
        return doctorList;
    }
}
