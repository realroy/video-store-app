package com.example.jab.videostore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Customer implements Serializable, Observer {
	private String id, password, address;
	private double balance;
	private List<Video> wishList;
	private Video[] videos;

	// Empty constructor for firebase realtime database
	public Customer() {
		wishList = new ArrayList<Video>();

		videos = new Video[1];
		videos[0] = new Video("Jeeper Creeper","Horor","Creep guy try to eat gay.",12, 0,"google.com");
	}

	public Customer(String id, String password, String address) {
		this.id = id;
		this.password = password;
		this.address = address;
		wishList = new ArrayList<Video>();
		videos = new Video[1];
		videos[0] = new Video("Jeeper Creeper","Horor","Creep guy try to eat gay.",12, 0,"google.com");
	}

	public  Video[] getVideos(){
		return videos;
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


	public void addToWishList(Video vid){
		wishList.add(vid);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(arg1 instanceof Video){
			Video temp = (Video) arg1;
			if(wishList.contains(temp)){
				System.out.println(temp.getName() + " has been restock.");
			}
		}	else if(arg1 instanceof List){
			List<Video> temp = (List)arg1;
			for(Video vid: temp){
				if(wishList.contains(vid)) 
					System.out.println(vid.getName() + " has been restock.");
			}
		}
	}

}
