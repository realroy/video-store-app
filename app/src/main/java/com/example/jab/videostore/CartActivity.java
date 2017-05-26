package com.example.jab.videostore;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

public class CartActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        String[] clubList = {"Arsenal", "Chelsea", "Everton",
                "Liverpool", "Man City", "Man Utd", "Spurs","Arsenal", "Chelsea", "Everton",
                "Liverpool", "Man City", "Man Utd", "Spurs","Arsenal", "Chelsea", "Everton",
                "Liverpool", "Man City", "Man Utd", "Spurs" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this,
                android.R.layout.simple_list_item_1, clubList);
        Log.d("========>", "cart : ");
        setListAdapter(adapter);
    }
}
