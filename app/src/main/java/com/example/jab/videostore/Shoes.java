package com.example.jab.videostore;

/**
 * Created by Jab on 5/26/2017 AD.
 */

public class Shoes {
    private String brand,edition;
    private double price;
    private int amount;
    public Shoes(String brand,String edition,double price,int amount){
        this.brand = brand;
        this.edition = edition;
        this.price = price;
        this.amount = amount;
    }
    public String getBrand(){
        return this.brand;
    }
    public String getEdition(){
        return this.edition;
    }
    public double getPrice(){
        return this.price;
    }
    public int getAmount(){
        return this.amount;
    }
    public String toString(){
        return "name : "+this.brand+" edition : "+this.edition+" price : "+this.price;
    }
}
