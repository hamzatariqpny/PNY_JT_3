package com.android.pnyjt3.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.android.pnyjt3.db.dao.ContactDao;
import com.android.pnyjt3.db.dao.UserDao;
import com.android.pnyjt3.db.entities.ContactTable;
import com.android.pnyjt3.db.entities.UserTable;

@Database(entities = {UserTable.class, ContactTable.class}, version = 1)
    public abstract class MyDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract ContactDao contactDao();

    private static MyDatabase myDB = null;

    public synchronized static MyDatabase getInstance(Context context){
        if(myDB == null){
            myDB = Room.databaseBuilder(context,
                    MyDatabase.class, "blood_app_db")
                    .allowMainThreadQueries()
                    .build();
        }

        return  myDB;
    }

}
