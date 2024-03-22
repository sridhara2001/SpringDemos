package com.spring.setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {
	private int capacity;
	private String type;
	
	public Engine() {
		super();
	}

	public Engine(int capacity, String type) {
		super();
		this.capacity = capacity;
		this.type = type;
	}

	public int getCapacity() {
		return capacity;
	}

	@Value("${vehicle.engine.capacity}")
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getType() {
		return type;
	}

	@Value("${vehicle.engine.type}")
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Engine [capacity=" + capacity + ", type=" + type + "]";
	}
	
}
