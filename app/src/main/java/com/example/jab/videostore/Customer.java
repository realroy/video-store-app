package com.example.jab.videostore;

public class Customer {
	private String id, password, address;
	private double balance;

	public Customer(String id, String password, String address) {
		this.id = id;
		this.password = password;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id='" + id + '\'' +
				", password='" + password + '\'' +
				", address='" + address + '\'' +
				", balance=" + balance +
				'}';
	}
}
