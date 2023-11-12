package com.example.centre_formation.fragment;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.centre_formation.R;
import com.example.centre_formation.database.AppDataBase;
import com.example.centre_formation.entity.User;
import com.google.android.material.button.MaterialButton;

public class RegistrationFragment extends Fragment {
    MaterialButton register;
    TextView email, firstName, lastName, password, repassword,btnLogin;
    AppDataBase database;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = AppDataBase.getAppDatabase(getActivity());
    }

    @SuppressLint("StaticFieldLeak")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        email = view.findViewById(R.id.emailInRegistrationfrag);
        firstName = view.findViewById(R.id.firstNameInRegistrationfrag);
        lastName = view.findViewById(R.id.lastNameInRegistrationfrag);
        password = view.findViewById(R.id.passwordInRegistrationfrag);
        repassword = view.findViewById(R.id.repasswordInRegistrationfrag);

        btnLogin=view.findViewById(R.id.goToLoginInRegistrationfrag);
        btnLogin.setOnClickListener(e -> {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameInPortail, new LoginFragment())
                    .commit();
                });

        register = view.findViewById(R.id.btnRegisterInRegistrationfrag);
        register.setOnClickListener(e -> {
            if (!password.getText().toString().equals(repassword.getText().toString())) {
                Toast.makeText(getActivity(), "Passwords do not match", Toast.LENGTH_LONG).show();
            } else {
                User user = new User(firstName.getText().toString(), lastName.getText().toString(), "adresse",
                        "true", "classe", email.getText().toString(), 21342323, "STUDENT", password.getText().toString());

                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... voids) {
                        database.userDao().addUser(user);
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        // Display registration success message and navigate to login activity
                        Toast.makeText(getActivity(), "Registration successful", Toast.LENGTH_LONG).show();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameInPortail, new LoginFragment())
                                .commit();
                    }
                }.execute();
            }
        });

        return view;
    }
}