package com.android.pnyjt3.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.pnyjt3.ui.activties.contact.ContactAdapter;
import com.android.pnyjt3.R;

public class FirstFragment extends Fragment {


    ContactAdapter contactAdapter;
    TextView textView;
    String inputFromPrevoiousFragment;
    // Empty Constructor
    public FirstFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_first, container, false);

        Bundle bundle = getArguments();

        if (bundle != null) {
            if(bundle.containsKey("inputField")){
                inputFromPrevoiousFragment = bundle.getString("inputField");
            }

        }

        contactAdapter = new ContactAdapter(getActivity(),null);

        textView = v.findViewById(R.id.textView);

        textView.setText(inputFromPrevoiousFragment);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setUpFragment();
            }
        });
        return v;
    }

    public void setUpFragment(){

        // Instance of you Fragment
        SecondFragment secondFragment = new SecondFragment();

  /*
        // Manager of all the fragments
        FragmentManager fm = getSupportFragmentManager();
        // help in Transaction of Fragment
        FragmentTransaction ft = fm.beginTransaction();
        // add the Fragment to be moved
        ft.add(R.id.frame,firstFragment);
        // Action
        ft.commit();*/


        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.frame,secondFragment).commit();

    }
}