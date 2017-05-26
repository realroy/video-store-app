package com.example.jab.videostore;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    private Customer customer;
    private VideoListAdapter adapter;
    private ListView listView;
    private double totalCost = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent = getIntent();
        customer = (Customer) intent.getSerializableExtra("CUSTOMER");
        DatabaseReference ordersRef = FirebaseDatabase.getInstance().getReference("orders");
        listView = (ListView) findViewById(R.id.list_video);
        ArrayList<Video> videoList = new ArrayList<Video>();
        videoList.add(new Video("A", "A", "A", 5, 5, "A"));
        videoList.add(new Video("A", "A", "A", 5, 5, "A"));
        videoList.add(new Video("A", "A", "A", 5, 5, "A"));
        videoList.add(new Video("A", "A", "A", 5, 5, "A"));
        videoList.add(new Video("A", "A", "A", 5, 5, "A"));
        adapter = new VideoListAdapter(this, videoList, customer.getId());
        listView.setAdapter(adapter);
        ordersRef.child(customer.getId()).child("cartedProducts").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adapter.clear();
                for (DataSnapshot each: dataSnapshot.getChildren()) {
                    Video video = each.getValue(Video.class);
                    totalCost += video.getPrice();
                    adapter.add(video);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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
        intent.putExtra("CUSTOMER", customer);
        intent.putExtra("TOTAL_COST", totalCost);
        startActivity(intent);
    }
}
