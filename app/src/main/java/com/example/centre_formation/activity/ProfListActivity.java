package com.example.centre_formation.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.centre_formation.R;
import com.example.centre_formation.database.AppDataBase;
import com.example.centre_formation.entity.Prof;

import java.util.ArrayList;
import java.util.List;

public class ProfListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProfAdapter adapter;
    private List<Prof> profList = new ArrayList<>();

    private AppDataBase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_list);
        database = AppDataBase.getAppDatabase(this);
        recyclerView = findViewById(R.id.recycler_view_profs);
        adapter = new ProfAdapter(profList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        loadProfs();
    }

    private void loadProfs() {
        profList.addAll(database.profDao().getAllProf());
        adapter.notifyDataSetChanged();
    }

    public void onDeleteProf(int position) {
        Prof prof = profList.get(position);
        database.profDao().deleteProf(prof);
        adapter.deleteProf(position);
    }

    public void onUpdateProf(int mat) {
        Prof prof = profList.get(mat);
        Intent intent = new Intent(this, UpdateProfActivity.class);
        intent.putExtra("prof_id", prof.getMatricule());
        intent.putExtra("prof_name", prof.getNom());
        intent.putExtra("prof_surname", prof.getPrenom());
        intent.putExtra("prof_subject", prof.getMatiere());
        intent.putExtra("prof_classes", prof.getClasses());
        startActivity(intent);
    }
}