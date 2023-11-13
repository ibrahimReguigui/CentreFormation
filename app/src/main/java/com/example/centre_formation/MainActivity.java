package com.example.centre_formation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.centre_formation.activity.AjoutProf;
import com.example.centre_formation.activity.Login;
import com.example.centre_formation.activity.ProfListActivity;
import com.example.centre_formation.activity.Registration;
import com.example.centre_formation.database.AppDataBase;
import com.example.centre_formation.entity.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDataBase database;
    private List<User> userList = new ArrayList<>();
    SharedPreferences shared;
    TextView user;
    Button logout;
    SharedPreferences myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = AppDataBase.getAppDatabase(this);
      //  userList = database.userDao().getAllUser();

        Button login = findViewById(R.id.goToLogin);
        Button register = findViewById(R.id.goToRegister);
        login.setOnClickListener(e -> {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        });
        register.setOnClickListener(e -> {
            Intent intent2 = new Intent(this, Registration.class);
            startActivity(intent2);
        });
        Button goToAjoutProf = findViewById(R.id.goToAjoutProf);
        goToAjoutProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AjoutProf.class);
                startActivity(intent);
            }
        });
        Button viewProfsButton = findViewById(R.id.btnViewProfs);
        viewProfsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfListActivity.class);

                    startActivity(intent);


            }
        });

        shared = getSharedPreferences(Login.PREF, MODE_PRIVATE);
        user = findViewById(R.id.user);
        String userJson = shared.getString("connectedUser", "null");
        Gson gson = new Gson();
        if (!userJson.equals("null")) {
            User userJS = gson.fromJson(userJson, User.class);
            user.setText(userJS.getFirstName());
        }

        myPref = getSharedPreferences(Login.PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = myPref.edit();
        logout = findViewById(R.id.logoutmain);
        logout.setOnClickListener(e -> {
            editor.clear();
            editor.commit();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        });

    }


}