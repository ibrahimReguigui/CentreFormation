package com.example.centre_formation.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.centre_formation.MainActivity;
import com.example.centre_formation.R;
import com.example.centre_formation.database.AppDataBase;
import com.example.centre_formation.entity.Cours;

public class UpdateCours extends Fragment {
    SharedPreferences myPref;
    private Cours cours;
    EditText editTextTitre,editTextContenu,editTextMatiere;

    AppDataBase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_update_cours, container, false);
        myPref = getActivity().getSharedPreferences(MainActivity.PREF, Context.MODE_PRIVATE);
        database = AppDataBase.getAppDatabase(getActivity());
        cours = (Cours) getArguments().getSerializable("cours");

        editTextTitre = view.findViewById(R.id.editTextTitre);
        editTextContenu = view.findViewById(R.id.editTextContenu);
        editTextMatiere = view.findViewById(R.id.editTextMatiere);
        // ... initialisez d'autres champs ...

        if (cours != null) {
            editTextTitre.setText(cours.getTitre());
            editTextContenu.setText(cours.getContenu());
            editTextMatiere.setText(cours.getMatiere().name());
            // ... mettez à jour d'autres champs ...
        }

        Button buttonSave = view.findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUpdatedCours();
            }
        });

        return view;
    }

    private void saveUpdatedCours() {
        // Mettez à jour l'objet cours avec de nouvelles valeurs
        cours.setTitre(editTextTitre.getText().toString());
        cours.setContenu(editTextContenu.getText().toString());
        cours.setMatiere(Cours.Matiere.valueOf(editTextMatiere.getText().toString()));
        // ... autres mises à jour ...

        // Sauvegardez le cours mis à jour dans la base de données dans un thread séparé
        new Thread(new Runnable() {
            @Override
            public void run() {
                database.coursDao().UpdateCours(cours); // Votre méthode DAO pour mettre à jour le cours

                // Revenez au thread principal pour les actions UI après la mise à jour
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Par exemple, affichez un Toast ou revenez à l'écran précédent
                        Toast.makeText(getContext(), "Cours mis à jour", Toast.LENGTH_SHORT).show();
                        getActivity().getSupportFragmentManager().popBackStack();
                    }
                });
            }
        }).start();
    }

}
