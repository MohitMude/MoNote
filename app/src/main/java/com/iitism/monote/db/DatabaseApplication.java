package com.iitism.monote.db;

import android.app.Application;

import androidx.room.Room;

public class DatabaseApplication extends Application {
    Database database;
    @Override
    public void onCreate()
    {
        super.onCreate();
        database= Room.databaseBuilder(this,Database.class,Database.NAME).fallbackToDestructiveMigration().build();
    }

    public Database getDatabase()
    {
        return database;
    }
}
