package com.android.pnyjt3.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.android.pnyjt3.db.entities.ContactTable;
import com.android.pnyjt3.db.entities.UserTable;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertUser(UserTable userTable);

    @Delete
    void deleteUser(UserTable userTable);

    @Update
    void updateUser(UserTable userTable);

    @Query("SELECT * FROM UserTable")
    List<UserTable> getAllUser();

    @Query("SELECT * FROM UserTable where :id = user_id")
    List<UserTable> getSingleUser(String id);

}
