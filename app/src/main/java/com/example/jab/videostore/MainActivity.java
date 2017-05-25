package com.example.jab.videostore;

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
    private DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDb();
        initComponent();
        db.child("users").setValue("Test");
    }

    private void initDb() {
        db = FirebaseDatabase.getInstance().getReference("users");

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
    }

    private void onSignIn() {
        String username = text_username.getText().toString();
        final String password = text_password.getText().toString();
        db.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                String text = "Username or password is not correct!";
//                User user = dataSnapshot.getValue(User.class);
//                if (user != null) {
//                    text = (user.getPassword().equals(password)) ?
//                            "Login Successsfully" :
//                            text;
//                }
//                Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
