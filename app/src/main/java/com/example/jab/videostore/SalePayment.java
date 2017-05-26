package com.example.jab.videostore;

/**
 * Created by Jab on 5/26/2017 AD.
 */


public class SalePayment implements Payment{

    @Override
    public double calculate(double n) {
        return n*30/100;
    }

}
