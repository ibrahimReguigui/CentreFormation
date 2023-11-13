package com.example.centre_formation.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.centre_formation.entity.Event;

import java.util.List;

@Dao
public interface EventDao {
    @Insert
    void addEvent(Event event);

    @Query("SELECT * FROM event")
    List<Event> getAllEvents();

    @Delete
    void deleteEvent(Event event);

    @Update
    void updateEvent(Event event);


}
