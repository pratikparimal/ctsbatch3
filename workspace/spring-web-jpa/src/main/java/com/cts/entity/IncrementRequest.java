package com.cts.entity;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="INCREMENT_REQUEST_LOG")
public class IncrementRequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String employeeName;
	Date date;
	double amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public IncrementRequest(String employeeName, Date date, double amount) {
		super();
		this.employeeName = employeeName;
		this.date = date;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "IncrementRequest [id=" + id + ", employeeName=" + employeeName + ", date=" + date + ", amount=" + amount
				+ "]";
	}
	
	

}
