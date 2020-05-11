package com.iitism.monote.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo
    String title;
    @ColumnInfo
    String note;
}
