package com.example.jab.videostore;

/**
 * Created by Jab on 5/13/2017 AD.
 */

 public class Video {
 	private String name,category,info;
 	private double price;
 	public Video(String name,double price,String category,String info){
 		this.name = name;
 		this.price = price;
 		this.category = category;
		this.info = info;
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
 	public void setInfo(String info){
		this.info = info;
	}
	public String getInfo(){
		return this.info;
	}
 }
