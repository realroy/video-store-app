package com.example.jab.videostore;


import java.io.Serializable;

/**
 * Created by Jab on 5/13/2017 AD.
 */

public class Video implements Product, Serializable {
	private String name,category,info;
	private double price;
	private int amount;
	private String imgUrl;

	// Empty Constructor for Firebase
	public Video() {

	}

	public Video(String name, String category, String info, double price, int amount, String imgUrl) {
		this.name = name;
		this.category = category;
		this.info = info;
		this.price = price;
		this.amount = amount;
		this.imgUrl = imgUrl;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "Video{" +
				"name='" + name + '\'' +
				", category='" + category + '\'' +
				", info='" + info + '\'' +
				", price=" + price +
				", amount=" + amount +
				", imgUrl='" + imgUrl + '\'' +
				'}';
	}
	public void restock() {
		this.amount += 10;
	}
	public boolean productAvailable(){
		return amount > 0;
	}
}
