package com.jsp.dto ;

public class EmployeeDto 
{
	private int id ;
	
	private String name ;
	
	private double contact ;
	
	private String designation ;
	
	private double salary ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double getContact() {
		return contact;
	}

	public void setContact(double contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "EmployeeDto [Employee id=" + id + ", Employee name=" + name + ", Employee contact=" + contact + ", Employee designation=" + designation
				+ ", Employee salary=" + salary + "]";
	}

	
	
	
}