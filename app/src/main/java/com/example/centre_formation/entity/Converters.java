package com.example.centre_formation.entity;

import androidx.room.TypeConverter;

public class Converters {
    @TypeConverter
    public static Cours.Matiere fromString(String value) {
        return value == null ? null : Cours.Matiere.valueOf(value);
    }

    @TypeConverter
    public static String matiereToString(Cours.Matiere matiere) {
        return matiere == null ? null : matiere.name();
    }
}
