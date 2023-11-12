package com.example.centre_formation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.centre_formation.activity.Login;
import com.example.centre_formation.activity.Registration;
import com.example.centre_formation.database.AppDataBase;
import com.example.centre_formation.entity.User;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Activity activity;
    private AppDataBase database;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    SharedPreferences shared;
    TextView user;
    Button logout;
    SharedPreferences myPref;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = AppDataBase.getAppDatabase(this);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navviewInMain);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,this.drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                }
                return false;
            }
        });

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