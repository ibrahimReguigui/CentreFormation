package com.example.centre_formation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.centre_formation.MainActivity;
import com.example.centre_formation.R;
import com.example.centre_formation.database.AppDataBase;
import com.example.centre_formation.entity.Role;
import com.example.centre_formation.entity.User;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;

public class Login extends AppCompatActivity {

    SharedPreferences myPref;
    public static final String PREF="pref";
    TextView email;
    private AppDataBase database ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myPref=getSharedPreferences(PREF,MODE_PRIVATE);
        SharedPreferences.Editor editor=myPref.edit();
        database = AppDataBase.getAppDatabase(this);

         email=findViewById(R.id.EmailInSignIn);
        TextView password=findViewById(R.id.passwordInSignIn);
        MaterialButton btnLogin=findViewById(R.id.btnloginInSignIn);
        TextView register=findViewById(R.id.goToRegisterInSignIn);

        btnLogin.setOnClickListener(e->{
            if (database != null) {
                User user=database.userDao().getUserByEmail(email.getText().toString()).get();
            if (user!=null && user.getPassword().equals(password.getText().toString())){
                Gson gson = new Gson();
                String userJson = gson.toJson(user);

                editor.putString("connectedUser", userJson);
                editor.commit();

                Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(this, MainActivity.class);
                startActivity(intent);
            }else
                Toast.makeText(this,"Wrong credentials",Toast.LENGTH_LONG).show();
        }else        Toast.makeText(this,"No database",Toast.LENGTH_LONG).show();
                }
        );


        register.setOnClickListener(e->{
            Intent intent=new Intent(this, Registration.class);
            startActivity(intent);
        });
    }
}