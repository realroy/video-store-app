package com.example.jab.videostore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jab on 5/13/2017 AD.
 */
 
public class Store {
	private static Store instance = null;
	private List<Video> videos;
	private Store(){
		// wait for code to retreive from database
		videos = new ArrayList<>();
//		Video v1 = new Video("Jeeper Creeper",19,"Horor","Creep guy try to eat gay.");
//		Video v2 = new Video("Brother of Grimby",50,"Comedy","Shitty duo brother wreck the world.");
//		videos.add(v1);
//		videos.add(v2);
	}
	public Store getInstance(){
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
}
