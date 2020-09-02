package com.android.pnyjt3.ui.activties.contact;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.pnyjt3.R;
import com.android.pnyjt3.db.MyDatabase;
import com.android.pnyjt3.db.entities.ContactTable;
import com.android.pnyjt3.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    Activity activity;
    List<ContactTable> contacts;
    MyDatabase myDatabase;

    public ContactAdapter(Activity activity, List<ContactTable> contacts) {
        this.activity = activity;
        this.contacts = contacts;
        // Database reference
        myDatabase = MyDatabase.getInstance(activity);

    }

    // Handle all the views
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = activity.getLayoutInflater().inflate(R.layout.row_contact,parent,false);
        return new ContactViewHolder(view);

    }

    // Handle data to be place on the view
    // this method gets called as many time as getItemCount is passed
    // position is the counter for Recycler view 0,1,2,3,4,5,6,7..10
    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, final int position) {

        final ContactTable contact = contacts.get(position);

        holder.contactName.setText(contact.contactName);
        holder.contactNumber.setText(contact.contactNumber);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // edit
                myDatabase.contactDao().deleteContact(getcontactTable(contact));

                // update recycler view
                contacts = myDatabase.contactDao().getAllContacts();
                notifyDataSetChanged();
            }
        });

    }

    // Tells you how many items to display on screen
    @Override
    public int getItemCount() {
        return contacts.size();
    }

     class ContactViewHolder extends RecyclerView.ViewHolder{

        ImageView contactImage;
        TextView contactName;
        TextView contactNumber;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            contactImage = itemView.findViewById(R.id.contactImage);
            contactName = itemView.findViewById(R.id.contactName);
            contactNumber = itemView.findViewById(R.id.contactNumber);

        }
    }

    public ContactTable getcontactTable(ContactTable ct){
        String name = ct.contactName+" edited";
        String number = ct.contactNumber+" edited";

        ContactTable contactTable = new ContactTable();
        contactTable.contactName = name;
        contactTable.contactNumber = number;
        contactTable.contactId = ct.contactId;

        return contactTable;
    }



}
