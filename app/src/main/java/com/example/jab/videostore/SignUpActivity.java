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
                final String password = text_password.getText().toString();
                final String username = text_username.getText().toString();
                final String address = text_address.getText().toString();
                String passwordAgain = text_password_again.getText().toString();
                if (!password.equals(passwordAgain)) {
                    Toast.makeText(SignUpActivity.this, "Password isn't the same value!", Toast.LENGTH_SHORT).show();
                    return;
                }

                customersRef.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        boolean isUsernameExistence = dataSnapshot.hasChildren();
                        if (isUsernameExistence) {
                            Toast.makeText(SignUpActivity.this, "Username has already exist, Please Use another username", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Customer customer = new Customer(username, password, address);
                        customersRef.child(username).setValue(customer);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }


}
