package com.cts.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@XmlRootElement
public class Increment implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	Date incrementDate;
	
	@NotNull
	@Min(1)
	double amount;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	Employee employee;


	public Increment(){
		
	}
	public Increment(Date incrementDate, double amount) {
		super();
		this.incrementDate = incrementDate;
		this.amount = amount;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getIncrementDate() {
		return incrementDate;
	}


	public void setIncrementDate(Date incrementDate) {
		this.incrementDate = incrementDate;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}

	//Break the cyclic dependency
	@JsonIgnore
	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "Increment [id=" + id + ", incrementDate=" + incrementDate + ", amount=" + amount + "]";
	}
	
	

}
