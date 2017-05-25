package com.example.jab.videostore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText text_username;
    private EditText text_password;
    private Button button_sign_in;
    private Button button_sign_up;
    private DatabaseReference customerRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customerRef = FirebaseDatabase.getInstance().getReference("customers");
        initComponent();
    }

    private void initComponent() {
        text_username = (EditText) findViewById(R.id.text_username);
        text_password = (EditText) findViewById(R.id.text_password);
        button_sign_in = (Button) findViewById(R.id.button_sign_in);
        button_sign_up = (Button) findViewById(R.id.button_sign_up);

        View.OnClickListener onClickSignIn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSignIn();
            }
        };
        button_sign_in.setOnClickListener(onClickSignIn);
        button_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void onSignIn() {
        String username = text_username.getText().toString();
        final String password = text_password.getText().toString();
        customerRef.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String errorText = "Username or password is not correct!";
                Customer customer = dataSnapshot.getValue(Customer.class);
                if (customer != null) {
                    if (customer.getPassword().equals(password)) {
                        Intent intent = new Intent(MainActivity.this, StoreActivity.class);
                        intent.putExtra("CUSTOMER", customer);
                        startActivity(new Intent(MainActivity.this, StoreActivity.class));
                    } else {
                        Toast.makeText(MainActivity.this, errorText, Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
