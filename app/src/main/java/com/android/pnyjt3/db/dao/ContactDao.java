package com.android.pnyjt3.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.android.pnyjt3.db.entities.ContactTable;

import java.util.List;

@Dao
public interface ContactDao {

    @Insert
    void insertContact(ContactTable contactTable);

    @Delete
    void deleteContact(ContactTable contactTable);

    @Update
    void updateContact(ContactTable contactTable);

    @Query("SELECT * FROM ContactTable")
    List<ContactTable> getAllContacts();

    @Query("SELECT * FROM ContactTable where :id = contactId")
    List<ContactTable> getSingleContacts(String id);

}
