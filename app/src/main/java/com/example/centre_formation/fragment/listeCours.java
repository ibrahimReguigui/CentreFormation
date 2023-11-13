package com.example.centre_formation.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.centre_formation.MainActivity;
import com.example.centre_formation.R;
import com.example.centre_formation.database.AppDataBase;
import com.example.centre_formation.entity.Cours;

import java.util.List;


public class listeCours extends Fragment {
    SharedPreferences myPref;
    AppDataBase database;
    private Button addButton;

    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = AppDataBase.getAppDatabase(getActivity());
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=inflater.inflate(R.layout.fragment_liste_cours, container, false);
        myPref = getActivity().getSharedPreferences(MainActivity.PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPref.edit();
        database = AppDataBase.getAppDatabase(getActivity());

        listView = view.findViewById(R.id.listView);
        addButton = view.findViewById(R.id.addButton);

// Récupérer la liste des cours depuis la base de données
        List<Cours> coursList = database.coursDao().getAllCours();

// Utiliser un adaptateur pour afficher la liste dans le ListView
        ArrayAdapter<Cours> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, coursList);
        listView.setAdapter(adapter);

// Ajouter un listener sur le bouton "Add" pour ouvrir le fragment d'ajout
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddFragment();
            }
        });

        return view;
    }

    private void openAddFragment() {
        // Remplacez le fragment actuel par le fragment d'ajout
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new CoursFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}