package com.example.jab.videostore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String id, password , address;
	private double balance;
	private List<Video> cart;

	public Customer(String id, String password,String address, int balance) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.password = password;
		this.balance = balance;
		this.address = address;
		cart = new ArrayList<>();
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAdress(){
		return this.address;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void addToCart(Video v){
		cart.add(v);
	}
	public void checkOut(){
		double totalCost = 0;
		for(Video vid : cart){
			totalCost += vid.getPrice();
		}
		balance -= totalCost;
	}
	
}
