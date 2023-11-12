package com.example.centre_formation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.centre_formation.activity.Registration;
import com.example.centre_formation.database.AppDataBase;
import com.example.centre_formation.entity.User;
import com.example.centre_formation.fragment.LoginFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private AppDataBase database;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    SharedPreferences shared;
    public static final String PREF = "pref";
    TextView userEmailInHeader, userNameInHeader;
    Button logout;

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

        shared = getSharedPreferences(PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();

        database = AppDataBase.getAppDatabase(this);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navviewInMain);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, this.drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.loginInMenu) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }
                if (item.getItemId() == R.id.logoutInMenu) {
                    editor.clear();
                    editor.commit();
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });


    }


}