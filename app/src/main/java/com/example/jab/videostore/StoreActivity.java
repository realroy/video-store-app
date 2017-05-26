package com.example.jab.videostore;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StoreActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Customer customer;
    private RecyclerView recycle_view_video;
    private List<Video> videoList;
    private DatabaseReference videosRef;
    private VideoAdapter videoAdapter;
    private EditText text_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Store");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.inflateHeaderView(R.layout.nav_header_store);

        Intent intent = getIntent();
        customer = (Customer)intent.getSerializableExtra("CUSTOMER");
        recycle_view_video = (RecyclerView) findViewById(R.id.recycle_view_video);
        text_search = (EditText) findViewById(R.id.text_search);
        videoList = new ArrayList<>();
        videoList.add(new Video("Proxy", "Proxy", "Proxy", 1, 1, "Proxy"));
        videosRef = FirebaseDatabase.getInstance().getReference("videos");
        videosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                videoList = new ArrayList<Video>();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    videoList.add(postSnapshot.getValue(Video.class));
                }
                videoAdapter = new VideoAdapter(StoreActivity.this, videoList, customer.getId());
                recycle_view_video.setAdapter(videoAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(StoreActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        videoAdapter = new VideoAdapter(this, videoList, customer.getId());

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recycle_view_video.setLayoutManager(layoutManager);
        recycle_view_video.setAdapter(videoAdapter);
        text_search.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Toast.makeText(StoreActivity.this, text_search.getText().toString(), Toast.LENGTH_SHORT);
                videosRef.orderByChild("name").startAt(text_search.getText().toString()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        videoList = new ArrayList<Video>();
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            videoList.add(postSnapshot.getValue(Video.class));
                        }
                        videoAdapter = new VideoAdapter(StoreActivity.this, videoList, customer.getId());
                        recycle_view_video.setAdapter(videoAdapter);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.store, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            // Handle the camera action
            Intent intent = new Intent(StoreActivity.this, ProfileActivity.class);
            intent.putExtra("CUSTOMER", customer);
            startActivity(intent);

        } else if (id == R.id.nav_cart) {
            Intent intent = new Intent(StoreActivity.this, CartActivity.class);
            intent.putExtra("CUSTOMER", customer);
            startActivity(intent);
        } else if (id == R.id.nav_top_up) {
            Intent intent = new Intent(StoreActivity.this, TopUpActivity.class);
            intent.putExtra("CUSTOMER", customer);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
