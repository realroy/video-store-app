package com.example.jab.videostore;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Jab on 5/13/2017 AD.
 */

public class Store extends Observable {
	private static Store instance = null;
	private List<Video> videos;
	private Store(){
		// wait for code to retreive from database
		videos = new ArrayList<>();
		Video v1 = new Video("Jeeper Creeper","Horor","Creep guy try to eat gay.",12, 0,"google.com");
		Video v2 = new Video("Brother of Grimby","Comedy","Shitty duo brother wreck the world.",12, 1,"");
		videos.add(v1);
		videos.add(v2);
	}
	public static Store getInstance(){
		if(instance == null){
			instance = new Store();
		}
		return instance;
	}
	public List<Video> getAllVideos(){
		return videos;
	}
	public Video getVideo(int index){
		return videos.get(index);
	}

	public void restock(Video vid){
		if(videos.get(videos.indexOf(vid)).productAvailable()) 
			System.out.println("Product still available.");
		else {
			videos.get(videos.indexOf(vid)).restock();
			setChanged();
			notifyObservers(vid);
		}
	}

	public void restockAll(){
		for(Video vid: videos){
			if(!vid.productAvailable()) vid.restock();
		}
		setChanged();
		notifyObservers(videos);
	}

	public void buy(Video vid){
		if(vid.productAvailable()){
			Video temp = videos.get(videos.indexOf(vid));
			videos.get(videos.indexOf(vid)).setAmount(temp.getAmount() - 1);
		}	else{
			System.out.println(vid.getName() + " is out of stock");
		}
	}
}
