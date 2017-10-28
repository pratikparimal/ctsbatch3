package com.cts.entity;

public class Employee {
	int id;
	String code;
	String name;
	String city;
	int salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Employee(){
		
	}
	public Employee(String code, String name, String city, int salary) {
		super();
		this.code = code;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [code=" + code + ", name=" + name + ", city=" + city + ", salary=" + salary + "]";
	}
}
