package com.example.jab.videostore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmPaymentActivity extends AppCompatActivity {
private Customer customer;
    private Payment payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cofirm_payment);
        Intent intent = getIntent();
        customer = (Customer) intent.getSerializableExtra("CUSTOMER");
        System.out.println("++++++++++++++++++++++++++++ "+customer.getId());
        double total = 0;
        if(customer.getBalance()>5000){
            payment = new SalePayment();

        }
        else{
            payment = new NomalPayment();

        }


        TextView amount = (TextView) findViewById(R.id.textView_amount);
        amount.setText("800");



        Button confirm = (Button) findViewById(R.id.btn_confirm_payment);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmPayment();
            }
        });
    }

    public void confirmPayment(){
        Intent intent = new Intent(ConfirmPaymentActivity.this,ProfileActivity.class);
        intent.putExtra("CUSTOMER",customer);
        startActivity(intent);
    }
}
