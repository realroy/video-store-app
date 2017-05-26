package com.example.jab.videostore;

/**
 * Created by Jab on 5/13/2017 AD.
 */

 public class Video implements Product{
 	private String name,category,info;
 	private double price;
	private int amount;
 	public Video(String name,double price,String category,String info,int amount){
 		this.name = name;
 		this.price = price;
 		this.category = category;
		this.info = info;
		this.amount = amount;
 	}
 	public String getName() {
 		return name;
 	}
 	public double getPrice() {
 		return price;
 	}
 	public String getCategory() {
 		return category;
 	}

	@Override
	public int getAmount() {
		return this.amount;
	}

	public String toString(){
 		return "Name : "+name+" Price : "+price+" Category : "+category;
 	}
 	public void setInfo(String info){
		this.info = info;
	}
	public String getInfo(){
		return this.info;
	}
 }
