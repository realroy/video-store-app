package com.example.jab.videostore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TopUpActivity extends AppCompatActivity {
    private Customer customer;
    private double money_to_add;
    private DatabaseReference customerRef = FirebaseDatabase.getInstance().getReference("customers");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);
        Intent intent = getIntent();
        customer = (Customer) intent.getSerializableExtra("CUSTOMER");
        Log.d("A------------>", "onDataChange: " + customer.getId());
        Button confirm = (Button) findViewById(R.id.btn_confirm);
        EditText money = (EditText)findViewById(R.id.text_amountMoney);
        money_to_add = customer.getBalance();
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMoney(money_to_add);
            }
        });
    }
    public void addMoney(double money){
        this.money_to_add += money;
        customerRef.child(customer.getId())
                .child("balance")
                .setValue(money_to_add);
        Log.d("===================", "addMoney: "+customerRef.getId());
        Toast.makeText(this, ""+customer.getBalance(), Toast.LENGTH_SHORT).show();
    }
}
