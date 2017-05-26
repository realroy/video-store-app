package com.example.jab.videostore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ConfirmPaymentActivity extends AppCompatActivity {
private Customer customer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cofirm_payment);
        Intent intent = getIntent();
        customer = (Customer) intent.getSerializableExtra("CUSTOMER");
        System.out.println("++++++++++++++++++++++++++++ "+customer.getId());
        double total = 0;
//        for(Video e : customer.getVideos()){
//            total += e.getPrice();
//        }
        System.out.println("++++++++++++++++++++++++++++ "+total);
//        Video[] video = customer.getVideo();
//        for (Video e : video){
//            System.out.println(e);
        //}
    }
}
