package com.example.centre_formation.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.centre_formation.entity.Cours;
import com.example.centre_formation.entity.User;

import java.util.List;

@Dao
public interface CoursDao {

    @Insert
    void addCours(Cours cours);
    @Delete
    void deleteCours(Cours cours);
    @Query("SELECT * FROM cours_table")
    List<User> getAllUsers();
    @Update
    void UpdateCours(Cours user);

}
