package com.spring.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Vehicle {
	private Integer vehicleId;
	private String model;
	private String brand;
	private double price;
	private Engine engine;
	
	public Vehicle() {
		super();
	}

	public Vehicle(Integer vehicleId, String model, String brand, double price) {
		super();
		this.vehicleId = vehicleId;
		this.model = model;
		this.brand = brand;
		this.price = price;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	@Value("${vehicle.vehicleId}")
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getModel() {
		return model;
	}

	@Value("${vehicle.model}")
	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	@Value("${vehicle.brand}")
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	@Value("200000")
	public void setPrice(double price) {
		this.price = price;
	}

	public Engine getEngine() {
		return engine;
	}

	@Autowired
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", model=" + model + ", brand=" + brand + ", price=" + price
				+ ", engine=" + engine + "]";
	}
	
}
