package com.example.jab.videostore;

/**
 * Created by Jab on 5/26/2017 AD.
 */

public class ShoesAdapter implements Product{
    private Shoes shoes;
    public ShoesAdapter(String brand,String edition,double price,int amount){
        shoes = new Shoes(brand,edition,price,amount);
    }
    @Override
    public String getName() {
        return shoes.getBrand();
    }

    @Override
    public double getPrice() {
        return shoes.getPrice();
    }

    @Override
    public String getCategory() {
        return shoes.getEdition();
    }

    @Override
    public int getAmount() {
        return shoes.getAmount();
    }
    @Override
    public String toString(){
        return shoes.toString();
    }
}
