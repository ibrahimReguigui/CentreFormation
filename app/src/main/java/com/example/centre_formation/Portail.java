package com.example.centre_formation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.centre_formation.database.AppDataBase;
import com.example.centre_formation.fragment.LoginFragment;
import com.example.centre_formation.fragment.RegistrationFragment;

public class Portail extends AppCompatActivity {
    AppDataBase database;

    SharedPreferences shared;
    public static final String PREF = "pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portail);

        database = AppDataBase.getAppDatabase(this);

        database.userDao().getAllUser();

        shared = getSharedPreferences(PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameInPortail, new RegistrationFragment())
                .commit();

    }
}