package com.android.pnyjt3.ui.activties;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.android.pnyjt3.ui.fragments.FirstFragment;
import com.android.pnyjt3.R;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        setUpFragment();
    }

    public void setUpFragment(){

        // Instance of you Fragment
        FirstFragment firstFragment = new FirstFragment();

        // Manager of all the fragments
        FragmentManager fm = getSupportFragmentManager();
        // help in Transaction of Fragment
        FragmentTransaction ft = fm.beginTransaction();
        // add the Fragment to be moved
        ft.add(R.id.frame,firstFragment);
        // Action
        ft.commit();


       // getSupportFragmentManager().beginTransaction().add(R.id.frame,firstFragment).commit();

    }


}