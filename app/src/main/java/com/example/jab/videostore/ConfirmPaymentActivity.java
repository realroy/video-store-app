package com.example.jab.videostore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfirmPaymentActivity extends AppCompatActivity {
    private Customer customer;
    private double totalCost;
    private Payment payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cofirm_payment);
        Intent intent = getIntent();
        customer = (Customer) intent.getSerializableExtra("CUSTOMER");
        final double totalCost = intent.getExtras().getDouble("TOTAL_COST");
        TextView amount = (TextView) findViewById(R.id.textView_amount);
        Button confirm = (Button) findViewById(R.id.btn_confirm_payment);
        amount.setText(String.valueOf(totalCost));
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payment = (customer.getBalance() > 5000) ? new SalePayment() : new NomalPayment();
                double newTotalCost = payment.calculate(totalCost);
                if (customer.getBalance() < newTotalCost) {
                    Toast.makeText(ConfirmPaymentActivity.this, "Insufficient balance! Please top up your balance", Toast.LENGTH_SHORT).show();
                } else {
                    DatabaseReference customersRef = FirebaseDatabase.getInstance().getReference("customers");
                    double result = customer.getBalance() - newTotalCost;
                    customersRef.child(customer.getId()).child("balance").setValue(result);
                    Intent intent = new Intent(ConfirmPaymentActivity.this, ProfileActivity.class);
                    intent.putExtra("CUSTOMER", customer);
                    startActivity(intent);
                }
            }
        });



    }
}
