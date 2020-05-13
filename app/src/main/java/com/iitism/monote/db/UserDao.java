package com.iitism.monote.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User where id == :id")
    public User getById(int id);

    @Query("SEleCT * FROM user")
    public List<User> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Long insertUser(User user);

    @Delete
    public void deleteUser(User user);


}
