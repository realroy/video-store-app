package com.example.jab.videostore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class ProfileActivity extends AppCompatActivity {
    private DatabaseReference customerRef = FirebaseDatabase.getInstance().getReference("customers");
    private double bal;
    private Customer customer;
    private TextView balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        customer = (Customer) intent.getSerializableExtra("CUSTOMER");
        bal = customer.getBalance();
        TextView name = (TextView) findViewById(R.id.textView_user_name);
        name.setText("ID : "+customer.getId());
        TextView address = (TextView) findViewById(R.id.textView_user_address);

        address.setText("ADDRESS : "+customer.getAddress());
        //customer = dataSnapshot.getValue(Customer.class);

        balance = (TextView) findViewById(R.id.textView_user_balance);

        Button store = (Button) findViewById(R.id.btn_back_store);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ProfileActivity.this,StoreActivity.class);
                intent1.putExtra("CUSTOMER",customer);
                startActivity(intent1);

            }
        });

        customerRef.child(customer.getId()).child("balance").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               bal = dataSnapshot.getValue(Double.class);
                balance.setText("BALANCE : "+bal);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
