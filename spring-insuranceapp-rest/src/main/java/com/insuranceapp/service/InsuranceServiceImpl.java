package com.insuranceapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.insuranceapp.model.Insurance;

@Service
public class InsuranceServiceImpl implements IInsuranceService {

	@Override
	public List<Insurance> getAll() {
		List<Insurance> insurances = getAllInsurance();
		return insurances;
	}

	@Override
	public Insurance getById(int insuranceId) {
		List<Insurance> insurances = getAllInsurance();
		for(Insurance insurance : insurances) {
			if(insurance.getInsuranceId()==insuranceId) {
				return insurance;
			}
		}
		return null;
	}

	private List<Insurance> getAllInsurance(){
		return Arrays.asList(
				new Insurance(101, "V0-H001", "Voya", "Health", 10, 10000),
				new Insurance(102, "BJ-M01", "Bajaj", "Motor", 14, 20000),
				new Insurance(103, "FI-Life", "Fidelity", "Life", 15, 5000),
				new Insurance(104, "VO-Mx01", "Voya", "Health", 13, 8000),
				new Insurance(105, "FI-Motor", "Fidelity", "Motor", 11, 15000)
				);
	}
}
