package com.android.pnyjt3.ui.activties;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.pnyjt3.R;
import com.android.pnyjt3.db.MyDatabase;
import com.android.pnyjt3.db.entities.ContactTable;
import com.android.pnyjt3.ui.activties.contact.RecyclerViewActivity;

import java.util.List;

public class DatabaseActivity extends AppCompatActivity {

    Button add, update , fetch , delete;
    EditText contactName , contactNumber;
    MyDatabase myDatabase;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        add = findViewById(R.id.add);
        update = findViewById(R.id.update);
        fetch = findViewById(R.id.fetch);
        delete = findViewById(R.id.delete);
        contactName = findViewById(R.id.contactName);
        contactNumber = findViewById(R.id.contactNumber);

        // Database reference
        myDatabase =MyDatabase.getInstance(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabase.contactDao().insertContact(getcontactTable());
            }
        });


        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DatabaseActivity.this, RecyclerViewActivity.class));
            }
        });


        sharedPreferences= getSharedPreferences("blood_app_sp",MODE_PRIVATE);


        String name = sharedPreferences.getString("contactName","no value stored");
        boolean isUserLogin = sharedPreferences.getBoolean("isUserLogin",false);
        contactName.setText(name);


    }

    public ContactTable getcontactTable(){
        String name = contactName.getText().toString();
        String number = contactNumber.getText().toString();

        editor = sharedPreferences.edit();
        editor.putString("contactName",name);
        editor.putBoolean("isUserLogin",true);
        editor.apply();

        ContactTable contactTable = new ContactTable();
        contactTable.contactName = name;
        contactTable.contactNumber = number;

        return contactTable;
    }
}