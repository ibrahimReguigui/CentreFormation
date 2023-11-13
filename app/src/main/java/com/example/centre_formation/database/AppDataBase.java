package com.example.centre_formation.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.centre_formation.dao.ProfDao;
import com.example.centre_formation.dao.UserDao;
import com.example.centre_formation.entity.Prof;
import com.example.centre_formation.entity.User;

@Database(entities = {User.class, Prof.class}, version = 2, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance;
    public abstract UserDao userDao();
    public abstract ProfDao profDao();
    // Define the migration from version 1 to 2
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `prof` (`matricule` INTEGER NOT NULL, `nom` TEXT, `prenom` TEXT, `matiere` TEXT, `classes` TEXT, PRIMARY KEY(`matricule`))");
        }
    };
    public static AppDataBase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "centre_formation_db").addMigrations(MIGRATION_1_2)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
