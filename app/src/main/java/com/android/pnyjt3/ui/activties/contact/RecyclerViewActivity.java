package com.android.pnyjt3.ui.activties.contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.pnyjt3.R;
import com.android.pnyjt3.db.MyDatabase;
import com.android.pnyjt3.model.Contact;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView contactRv;
    ArrayList <Contact> contacts = new ArrayList<>();

    MyDatabase myDatabase;
    ContactAdapter contactAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        myDatabase =MyDatabase.getInstance(this);

        contactRv =findViewById(R.id.contactsRV);

        contactAdapter = new ContactAdapter(this, myDatabase.contactDao().getAllContacts());

        contactRv.setLayoutManager(new LinearLayoutManager(this));

        contactRv.setAdapter(contactAdapter);


    }

    // Getting contacts from DB
    // Getting contact from live server
    public void getContact(){

        Contact contact = new Contact("Hamza","001",R.drawable.mechanic);
        contacts.add(contact);
        Contact contact1 = new Contact("haris","002",R.drawable.worker);
        contacts.add(contact1);
        Contact contact2 = new Contact("ali","003",R.drawable.multitasking);
        contacts.add(contact2);
        Contact contact3 = new Contact("hassan","004",R.drawable.programmer);
        contacts.add(contact3);
        Contact contact4 = new Contact("raza","005",R.drawable.worker);
        contacts.add(contact4);
        Contact contact5 = new Contact("farhan","006",R.drawable.programmer);
        contacts.add(contact5);
        Contact contact6 = new Contact("Ali","007",R.drawable.multitasking);
        contacts.add(contact6);
        Contact contact7 = new Contact("ahmed","008",R.drawable.programmer);
        contacts.add(contact7);
        Contact contact8 = new Contact("zain","009",R.drawable.ic_pharmacy);
        contacts.add(contact8);
        Contact contact9 = new Contact("mubeen","010",R.drawable.programmer);
        contacts.add(contact9);
        Contact contact15 = new Contact("farhan","015",R.drawable.programmer);
        contacts.add(contact15);
        Contact contact16 = new Contact("Ali","016",R.drawable.multitasking);
        contacts.add(contact16);
        Contact contact17 = new Contact("ahmed","017",R.drawable.programmer);
        contacts.add(contact17);
        Contact contact18 = new Contact("zain","018",R.drawable.ic_pharmacy);
        contacts.add(contact18);
        Contact contact19 = new Contact("mubeen","019",R.drawable.programmer);
        contacts.add(contact19);

    }



}