package com.example.jab.videostore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        Customer customer = (Customer) intent.getSerializableExtra("CUSTOMER");
        TextView name = (TextView) findViewById(R.id.textView_user_name);
        name.setText("ID : "+customer.getId());
        TextView address = (TextView) findViewById(R.id.textView_user_address);
        address.setText("ADDRESS : "+customer.getAddress());
        TextView balance = (TextView) findViewById(R.id.textView_user_balance);
        balance.setText("BALANCE : "+customer.getBalance());


    }
}
