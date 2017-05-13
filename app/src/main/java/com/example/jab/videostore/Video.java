package com.example.jab.videostore;

/**
 * Created by Jab on 5/13/2017 AD.
 */

 public class Video {
 	private String name;
 	private double price;
 	private String category;
 	public Video(String name,double price,String category){
 		this.name = name;
 		this.price = price;
 		this.category = category;
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
 	public String toString(){
 		return "Name : "+name+" Price : "+price+" Category : "+category;
 	}
 }
