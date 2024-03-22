package com.doctorapp.repository;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.exception.IdNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.util.Queries;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorRepositoryImpl implements IDoctorRepository {
	private JdbcTemplate jdbcTemplate;
	
    public DoctorRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addDoctor(Doctor doctor) {
       Object[] doctorArray = {doctor.getDoctorId(),doctor.getDoctorName(),doctor.getSpeciality(),doctor.getFees(),doctor.getRatings(),doctor.getExperience()};
       jdbcTemplate.update(Queries.INSERTQUERY, doctorArray);
	}

    public void updateDoctor(int doctorId, double fees) {
    	jdbcTemplate.update(Queries.UPDATEQUERY,fees,doctorId);
    }

    public void deleteDoctor(int doctorId) {
    	jdbcTemplate.update(Queries.DELETEQUERY,doctorId);
    }

    public Doctor findById(int doctorId) throws IdNotFoundException {
    	Doctor doctor = jdbcTemplate.queryForObject(Queries.FINDBYID, new DoctorMapper(), doctorId);
		return doctor;
    }

    public List<Doctor> findAll() {
    	RowMapper<Doctor> mapper = new DoctorMapper();
		List<Doctor> doctors = jdbcTemplate.query(Queries.FINDALLQUERY, mapper);
		return doctors;
    }

    public List<Doctor> findBySpeciality(String speciality) throws DoctorNotFoundException {
    	return jdbcTemplate.query(Queries.FINDBYSPECIALITY, new DoctorMapper(), speciality);
    }

    public List<Doctor> findBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException {
    	List<Doctor> doctors = jdbcTemplate.query(Queries.FINDBYSPECANDEXP,new DoctorMapper(), speciality, experience);
		return doctors;
    }

    public List<Doctor> findBySpecialityAndLessFees(String speciality, double fees) throws DoctorNotFoundException {
    	List<Doctor> doctors = jdbcTemplate.query(Queries.FINDBYSPECANDFEES,new DoctorMapper(), speciality, fees);
		return doctors;
    }

    public List<Doctor> findBySpecialityAndRatings(String speciality, int ratings) throws DoctorNotFoundException {
    	List<Doctor> doctors = jdbcTemplate.query(Queries.FINDBYSPECANDRATINGS,new DoctorMapper(), speciality, ratings);
		return doctors;
    }

    public List<Doctor> findBySpecialityAndNameContains(String speciality, String doctorName) throws DoctorNotFoundException {
    	List<Doctor> doctors = jdbcTemplate.query(Queries.FINDBYSPECANDNAME,new DoctorMapper(), speciality, doctorName);
		return doctors;
    }
}
