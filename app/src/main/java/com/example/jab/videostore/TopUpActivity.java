package com.example.jab.videostore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        Button btn_back = (Button) findViewById(R.id.btn_back);
        money_to_add = customer.getBalance();
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMoney();
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TopUpActivity.this, StoreActivity.class));
            }
        });
    }
    public void addMoney(){
        EditText money = (EditText)findViewById(R.id.text_amountMoney);
        System.out.println("=========================>"+money.getText(  ).toString());
        this.money_to_add += Integer.parseInt(money.getText().toString());
        customerRef.child(customer.getId())
                .child("balance")
                .setValue(money_to_add);
        customerRef.child(customer.getId()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                customer = dataSnapshot.getValue(Customer.class);
                Toast.makeText(TopUpActivity.this, "" + customer.getBalance(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
