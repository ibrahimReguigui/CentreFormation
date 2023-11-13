package com.example.centre_formation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.centre_formation.R;
import com.example.centre_formation.database.AppDataBase;
import com.example.centre_formation.entity.Prof;

public class UpdateProfActivity extends AppCompatActivity {
    private EditText editTextProfName, editTextProfSurname, editTextProfSubject, editTextProfClasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_prof);

        // Initialize EditText fields
        editTextProfName = findViewById(R.id.editTextProfName);
        editTextProfSurname = findViewById(R.id.editTextProfSurname);
        editTextProfSubject = findViewById(R.id.editTextProfSubject);
        editTextProfClasses = findViewById(R.id.editTextProfClasses);

        // Retrieve and set the data
        Intent intent = getIntent();
        if (intent != null) {
            String profName = intent.getStringExtra("prof_name");
            String profSurname = intent.getStringExtra("prof_surname");
            String profSubject = intent.getStringExtra("prof_subject");
            String profClasses = intent.getStringExtra("prof_classes");

            editTextProfName.setText(profName);
            editTextProfSurname.setText(profSurname);
            editTextProfSubject.setText(profSubject);
            editTextProfClasses.setText(profClasses);
        }

        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSaveClicked(v);
            }
        });
    }

    // Method to handle saving changes
    public void onSaveClicked(View view) {
        String name = editTextProfName.getText().toString();
        String surname = editTextProfSurname.getText().toString();
        String subject = editTextProfSubject.getText().toString();
        String classes = editTextProfClasses.getText().toString();


        // Get the professor ID passed through intent
        int profId = getIntent().getIntExtra("prof_id", -1);
        if (profId != -1) {
            // Update the professor's information
            Prof updatedProf = new Prof(name, surname, subject, classes);
            updatedProf.setMatricule(profId);

            // Update the database
            AppDataBase database = AppDataBase.getAppDatabase(this);
            database.profDao().updateProf(updatedProf);

            // Finish the activity, returning to the previous screen
            finish();
        } else {
        }
    }
}
