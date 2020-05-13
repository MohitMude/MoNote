package com.iitism.monote.db;


import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {User.class},version = 1)
public abstract class Database extends RoomDatabase {
    public abstract UserDao userDao();

    public static final String NAME="User";
    private static Database noteDB;

    public static Database getInstance(Context context)
    {
        if(noteDB==null)
        {
            noteDB=buildDatabaseInstance(context);
        }
        return noteDB;
    }

    private  static  Database buildDatabaseInstance(Context context)
    {
        return Room.databaseBuilder(context,Database.class,NAME).fallbackToDestructiveMigration().build();
    }

    public  void  cleanUp()
    {
        noteDB=null;
    }

}
