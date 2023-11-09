package com.example.centre_formation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class Registration extends AppCompatActivity {

    TextView email=findViewById(R.id.email);
    TextView firstName=findViewById(R.id.firstName);
    TextView lastName=findViewById(R.id.lastName);
    TextView password=findViewById(R.id.password);
    TextView repassword=findViewById(R.id.repassword);
    MaterialButton btnRegister=findViewById(R.id.btnRegister);
    TextView goToLogin=findViewById(R.id.goToLogin);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        goToLogin.setOnClickListener(e->{

        });
    }
}