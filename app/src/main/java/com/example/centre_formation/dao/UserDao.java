package com.example.centre_formation.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.centre_formation.entity.User;

import java.util.List;
import java.util.Optional;

@Dao
public interface UserDao {
    @Insert
    void addUser(User user);
    @Delete
    void deleteUser(User user);
    @Query("SELECT * FROM user_table")
    List<User> getAllUser();
    @Query("SELECT * FROM user_table WHERE email = :email")
    Optional<User> getUserByEmail(String email);
    @Update
    void updateUser(User user);
}
