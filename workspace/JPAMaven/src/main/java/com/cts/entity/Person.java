package com.cts.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Person {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	Address residentialAddress = new Address();
	
	@OneToMany(cascade=CascadeType.ALL)
	List<Address> addresses = new ArrayList<>();
	
	public Person(String name) {
		this.name = name;
	}
	public Person(){
		
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	//	public Address getResidentialAddress() {
//		return residentialAddress;
//	}
//	public void setResidentialAddress(Address residentialAddress) {
//		this.residentialAddress = residentialAddress;
//	}
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
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", addresses=" + addresses + "]";
	}
	
	
	

}
