package com.example.jab.videostore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpActivity extends AppCompatActivity {

    private EditText text_username;
    private EditText text_password;
    private EditText text_password_again;
    private EditText text_address;
    private Button btn_confirm;
    private DatabaseReference customersRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initComponent();
        customersRef = FirebaseDatabase.getInstance().getReference("customers");
    }

    private void initComponent() {
        text_address = (EditText) findViewById(R.id.text_address);
        text_password = (EditText) findViewById(R.id.text_password);
        text_password_again = (EditText) findViewById(R.id.text_password_again);
        text_username = (EditText) findViewById(R.id.text_username);
        btn_confirm = (Button) findViewById(R.id.button_confirm);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = text_username.getText().toString();
                customersRef.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot == null) {

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }


}
