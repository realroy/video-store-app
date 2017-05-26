package com.example.jab.videostore;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CartActivity extends ListActivity {
    private Customer customer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        Intent intent = getIntent();
        customer = (Customer) intent.getSerializableExtra("CUSTOMER");
        System.out.println("========================>>>>>>>>>>>>>>>>>>"+customer.getId());

        //Video[] video = customer.getVideos();
//        for (Video e : video){
//            System.out.println(e);
//        }
//        ArrayAdapter<Video> adapter = new ArrayAdapter<Video>( this,
//                android.R.layout.simple_list_item_1, customer.getVideos());
        Log.d("========>", "cart : ");
//        setListAdapter(adapter);

        Button confirm = (Button) findViewById(R.id.btn_confirm_order);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmOrder();
            }
        });

    }
    public void confirmOrder(){
        Intent intent = new Intent(CartActivity.this,ConfirmPaymentActivity.class);
        intent.putExtra("CUSTOMER",customer);
        startActivity(intent);
    }
}
