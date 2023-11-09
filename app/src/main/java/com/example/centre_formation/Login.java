package com.example.centre_formation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Login extends AppCompatActivity {
    TextView userName=findViewById(R.id.username);
    TextView password=findViewById(R.id.password);
    MaterialButton btnLogin=findViewById(R.id.btnlogin);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin.setOnClickListener(e->{
            if (userName.getText().toString().equals("admin") &&
            password.getText().toString().equals("admin")){
                Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT);
            }else
                Toast.makeText(this,"Wrong credentials",Toast.LENGTH_LONG);
        });
    }
}