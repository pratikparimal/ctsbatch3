package com.cts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String locatity;
	String city;
	
	public Address(){
		
	}
	
	public Address(String locatity, String city) {
		super();
		this.locatity = locatity;
		this.city = city;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLocatity() {
		return locatity;
	}


	public void setLocatity(String locatity) {
		this.locatity = locatity;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", locatity=" + locatity + ", city=" + city + "]";
	}
	
}
