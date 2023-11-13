package com.example.centre_formation.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.centre_formation.MainActivity;
import com.example.centre_formation.R;
import com.example.centre_formation.database.AppDataBase;
import com.example.centre_formation.entity.User;
import com.google.gson.Gson;


public class ProfileFragment extends Fragment {
    SharedPreferences myPref;
    AppDataBase database;
    TextView name,role,email,first,last,adresse,phoneNumber;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = AppDataBase.getAppDatabase(getActivity());
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile, container, false);

        myPref = getActivity().getSharedPreferences(MainActivity.PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPref.edit();

        database = AppDataBase.getAppDatabase(getActivity());

        String userJson = myPref.getString("connectedUser", "null");
        Gson gson = new Gson();
        User user = gson.fromJson(userJson, User.class);

        first=view.findViewById(R.id.firstNameInProfile2);
        last=view.findViewById(R.id.lastNameInProfile);
        email=view.findViewById(R.id.emailInProfile);
        adresse=view.findViewById(R.id.adresseInProfile);
        name=view.findViewById(R.id.nameInProfile);
        role=view.findViewById(R.id.roleInProfile);
        phoneNumber=view.findViewById(R.id.phoneInProfile);

        first.setText(user.getFirstName());
        last.setText(user.getLastName());
        email.setText(user.getEmail());
        adresse.setText(user.getAdress());
        name.setText(user.getFirstName()+" "+user.getLastName());
        role.setText(user.getRole());
        phoneNumber.setText(String.valueOf(user.getPhoneNumber()));

        return view;
    }
}