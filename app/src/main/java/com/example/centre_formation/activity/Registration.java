package com.example.centre_formation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.centre_formation.R;
import com.google.android.material.button.MaterialButton;

public class Registration extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        TextView email = findViewById(R.id.email);
        TextView firstName = findViewById(R.id.firstName);
        TextView lastName = findViewById(R.id.lastName);
        TextView password = findViewById(R.id.password);
        TextView repassword = findViewById(R.id.repassword);
        MaterialButton btnRegister = findViewById(R.id.btnRegister);
        TextView goToLogin = findViewById(R.id.goToLogin);

        goToLogin.setOnClickListener(e -> {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        });

        btnRegister.setOnClickListener(e -> {
            if (!password.getText().toString().equals(repassword.getText().toString())) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "Registration successfull", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
            }
        });
    }
}