package com.example.centre_formation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.centre_formation.R;
import com.example.centre_formation.database.AppDataBase;
import com.example.centre_formation.entity.Prof;
import com.google.android.material.button.MaterialButton;

public class AjoutProf extends AppCompatActivity {
    private AppDataBase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_prof);

        database = AppDataBase.getAppDatabase(this);

        EditText nom = findViewById(R.id.nom);
        EditText prenom = findViewById(R.id.prenom);
        EditText matiere = findViewById(R.id.matiere);
        EditText classes = findViewById(R.id.classes);
        Button btnAddProf = findViewById(R.id.btnAddProf);

        btnAddProf.setOnClickListener(e -> {
            if ( nom.getText().toString().isEmpty() || prenom.getText().toString().isEmpty()
            || matiere.getText().toString().isEmpty() || classes.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }
            Prof newProf = new Prof(
                    nom.getText().toString(),
                    prenom.getText().toString(),
                    matiere.getText().toString(),
                    classes.getText().toString()
            );


            try {
                database.profDao().addProf(newProf);
            } catch (Exception x) {
                x.printStackTrace();
                // Log the error or display a message
            }

            Toast.makeText(this, "Professor added successfully", Toast.LENGTH_LONG).show();


        });
    }
}
