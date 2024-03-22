package com.spring.constructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class Student {
	private String studentName;
	private String department;
	private Course course;
	
	// Here course will be injected using constructor
	// annotation autowired not required
	public Student(Course course) {
		super();
		this.course = course;
	}
	
	public String getStudentName() {
		return studentName;
	}
	@Value("${student.studentName}")
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getDepartment() {
		return department;
	}
	@Value("${student.department}")
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", department=" + department + ", course=" + course + "]";
	}
	
}
