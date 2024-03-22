package com.insuranceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuranceapp.exception.InsuranceNotFoundException;
import com.insuranceapp.model.Insurance;
import com.insuranceapp.repository.IInsuranceRepository;

@Service
public class InsuranceServiceImpl implements IInsuranceService {
	
	@Autowired
	IInsuranceRepository insuranceRepository;
	
	@Override
	public void addInsurance(Insurance insurance) {
		insuranceRepository.addInsurance(insurance);
	}

	@Override
	public void updateInsurance(int insuranceId, double premium) {
		insuranceRepository.updateInsurance(insuranceId, premium);
		
	}

	@Override
	public void deleteInsurance(int insuranceId) {
		insuranceRepository.deleteInsurance(insuranceId);
		
	}

	@Override
	public List<Insurance> getAll() {
		return insuranceRepository.findAll();
	}

	@Override
	public List<Insurance> getByBrand(String brand) throws InsuranceNotFoundException {
		List<Insurance> insurances = insuranceRepository.findByBrand(brand);
		if(insurances.isEmpty()) {
			throw new InsuranceNotFoundException();
		}
		return insurances;
	}

	@Override
	public List<Insurance> getByBrandAndType(String brand, String type) throws InsuranceNotFoundException {
		return insuranceRepository.findByBrandAndType(brand, type);
	}

	@Override
	public List<Insurance> getByTypeAndLessPremium(String type, double premium) throws InsuranceNotFoundException {
		return insuranceRepository.findByTypeAndLessPremium(type, premium);
	}

	@Override
	public Insurance getById(int insuranceId) throws InsuranceNotFoundException {
		return insuranceRepository.findById(insuranceId);
	}
	
//	private List<Insurance> getAllInsurance(){
//		return Arrays.asList(
//				new Insurance(101, "V0-H001", "Voya", "Health", 10, 10000),
//				new Insurance(102, "BJ-M01", "Bajaj", "Motor", 14, 20000),
//				new Insurance(103, "FI-Life", "Fidelity", "Life", 15, 5000),
//				new Insurance(104, "VO-Mx01", "Voya", "Health", 13, 8000),
//				new Insurance(105, "FI-Motor", "Fidelity", "Motor", 11, 15000)
//				);
//	}
}
