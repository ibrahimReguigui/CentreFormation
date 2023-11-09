package com.example.centre_formation.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.centre_formation.entity.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertOne(User user);
    @Delete
    void delete(User user);
    @Query("SELECT * FROM user_table")
    List<User> getAll();
    @Query("SELECT * FROM user_table WHERE email=:email")
    User getByEmail(String email);
    @Update
    void updateUser(User user);
}
