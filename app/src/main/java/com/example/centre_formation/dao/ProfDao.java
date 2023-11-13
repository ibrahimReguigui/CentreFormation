package com.example.centre_formation.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.centre_formation.entity.Prof;
import com.example.centre_formation.entity.User;

import java.util.List;

@Dao
public interface ProfDao {
    @Insert
    void addProf(Prof prof);
    @Delete
    void deleteProf(Prof prof);
    @Query("SELECT * FROM prof")
    List<Prof> getAllProf();
    @Query("SELECT * FROM prof WHERE matricule=:matricule")
    Prof getProfByMatricule(int matricule);

    @Update
    void updateProf(Prof prof);
}
