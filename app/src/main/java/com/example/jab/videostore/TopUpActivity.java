package com.example.jab.videostore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TopUpActivity extends AppCompatActivity {
    private Customer customer;
    private int money_to_add;
    private DatabaseReference customerRef = FirebaseDatabase.getInstance().getReference("customers");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);
        Intent intent = getIntent();
        customer = (Customer) intent.getSerializableExtra("CUSTOMER");
        Button confirm = (Button) findViewById(R.id.button_confirm);
        EditText money = (EditText)findViewById(R.id.text_amountMoney);
        money_to_add = Integer.parseInt(money.getText().toString());
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMoney(money_to_add);
            }
        });
    }
    public void addMoney(int money){
        this.money_to_add += money;
        customerRef.child(customer.getId())
                .child("balance")
                .setValue(money_to_add);
    }
}
