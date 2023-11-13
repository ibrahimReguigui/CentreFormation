package com.example.centre_formation.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "prof")
public class Prof {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "matricule")
    private int matricule;

    @ColumnInfo(name = "nom")
    private String nom;

    @ColumnInfo(name = "prenom")
    private String prenom;

    @ColumnInfo(name = "matiere")
    private String matiere;

    @ColumnInfo(name = "classes")
    private String classes;


    public Prof() {
    }

    public Prof(String nom, String prenom, String matiere, String classes) {
        this.nom = nom;
        this.prenom = prenom;
        this.matiere = matiere;
        this.classes = classes;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Prof(int matricule, String nom, String prenom, String matiere, String classes) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.matiere = matiere;
        this.classes = classes;
    }
}
