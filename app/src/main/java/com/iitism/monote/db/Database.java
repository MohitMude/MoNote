package com.iitism.monote.db;


import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {User.class},version = 1)
public abstract class Database extends RoomDatabase {
    public abstract UserDao userDao();

    public static final String NAME="User";


}
