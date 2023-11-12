package com.example.centre_formation.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.centre_formation.dao.UserDao;
import com.example.centre_formation.entity.DateConverter;
import com.example.centre_formation.entity.Formation;
import com.example.centre_formation.entity.User;

@Database(entities = {User.class, Formation.class}, version = 2, exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance;
    public abstract UserDao userDao();
    public static AppDataBase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "centre_formation_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
