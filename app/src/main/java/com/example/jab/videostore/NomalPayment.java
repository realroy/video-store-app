package com.example.jab.videostore;

/**
 * Created by Jab on 5/26/2017 AD.
 */

public class NomalPayment implements Payment{
    @Override
    public double calculate(double n){
        return n;
    }
}
