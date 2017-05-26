package com.example.jab.videostore;


import java.util.List;

public class Order {
	private List<Product> cartedProducts;
	private String customerId;
	
	public Order() {
		// TODO Auto-generated constructor stub	
	}
	
	public Order(List<Product> list, String customerId){
		cartedProducts = list;
		this.customerId = customerId;
	}

	public List<Product> getCartedProducts() {
		return cartedProducts;
	}

	public void setCartedProducts(List<Product> cartedProducts) {
		this.cartedProducts = cartedProducts;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
