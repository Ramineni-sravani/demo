package com.demo.model;

public class Customer {
	private int customerId;
	private String customerName;
	private String email;
	private  double cPoints;
	
	
	
	public Customer() {
		super();
	}
	public Customer(int customerId, String customerName, String email, double cPoints) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.cPoints = cPoints;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getcPoints() {
		return cPoints;
	}
	public void setcPoints(double cPoints) {
		this.cPoints = cPoints;
	}
	
	
	
	
	

}
