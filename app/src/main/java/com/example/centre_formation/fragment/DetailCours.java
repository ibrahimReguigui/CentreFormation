package com.example.centre_formation.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.centre_formation.CoursListAdapter;
import com.example.centre_formation.MainActivity;
import com.example.centre_formation.R;
import com.example.centre_formation.database.AppDataBase;
import com.example.centre_formation.entity.Cours;

import java.util.List;


public class DetailCours extends Fragment {
    SharedPreferences myPref;
    AppDataBase database;
    private TextView textViewDetail;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_cours, container, false);
        myPref = getActivity().getSharedPreferences(MainActivity.PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPref.edit();
        database = AppDataBase.getAppDatabase(getActivity());

        // Récupérez l'objet Cours passé
        Cours cours = (Cours) getArguments().getSerializable("cours");

        // Affichez les détails dans le TextView
        textViewDetail = view.findViewById(R.id.textViewDetail); // Assurez-vous que ce TextView est défini dans votre XML
        if (cours != null) {
            textViewDetail.setText(cours.toString()); // Mettez en forme comme vous le souhaitez
        }

        return view;

    }
}