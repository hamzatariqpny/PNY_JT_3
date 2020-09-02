package com.android.pnyjt3.ui.activties;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.pnyjt3.ui.fragments.FirstFragment;
import com.android.pnyjt3.R;

public class MainActivity extends AppCompatActivity {

    // variable declaration
    Button pressMe;
    EditText inputField;
    TextView outputField;

    String myInputString = "";

    // Creating Point
    // Callback when an Activity is created .
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // To connect from backend to Frontend
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","onCreate");
        pressMe = findViewById(R.id.pressMe);
        inputField = findViewById(R.id.inputField);
        outputField = findViewById(R.id.outputField);



        pressMe.setOnClickListener(new View.OnClickListener() {
            // polymorphism
            @Override
            public void onClick(View view) {
                // this code will be executed when the button us clicked
                // this will get the text which is written on the input field and store in String
                myInputString = inputField.getText().toString();
                // this will show the data stored in myInputString
                outputField.setText(myInputString);
                int age = 30;

                setUpFragment();

                // Intent // which is responsible for all the transition
                Intent moveToNextActivity = new Intent(MainActivity.this,FragmentActivity.class);
                startActivity(moveToNextActivity);

            }
        });
    }

    public void setUpFragment(){

        // Instance of you Fragment
        FirstFragment firstFragment = new FirstFragment();

        Bundle bundle = new Bundle();
        bundle.putString("inputField",myInputString);

        firstFragment.setArguments(bundle);

  /*
        // Manager of all the fragments
        FragmentManager fm = getSupportFragmentManager();
        // help in Transaction of Fragment
        FragmentTransaction ft = fm.beginTransaction();
        // add the Fragment to be moved
        ft.add(R.id.frame,firstFragment);
        // Action
        ft.commit();*/


         getSupportFragmentManager().beginTransaction().add(R.id.frame,firstFragment).commit();

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }

    // Starting Point
    // Callback when an Activity is started .
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStart");

        // Server Data
        // Database Data
        // Server Connection
    }

    // Activity running Point
    // Callback when an Activity is started .
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onDestroy");
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}