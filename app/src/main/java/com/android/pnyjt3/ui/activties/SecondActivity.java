package com.android.pnyjt3.ui.activties;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.pnyjt3.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("SecondActivity","onCreate");

        Intent intentFromPreviousActivity = getIntent();

        if(intentFromPreviousActivity != null){
            if(intentFromPreviousActivity.hasExtra("Ahmed")){
                int age = intentFromPreviousActivity.getIntExtra("Age",0);
                String dataFromPreviousActivity = intentFromPreviousActivity.getStringExtra("Ahmed");
                Toast.makeText(SecondActivity.this,dataFromPreviousActivity,Toast.LENGTH_LONG).show();
            }
        }

    }


    // Starting Point
    // Callback when an Activity is started .
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SecondActivity","onStart");

        // Server Data
        // Database Data
        // Server Connection
    }

    // Activity running Point
    // Callback when an Activity is started .
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SecondActivity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SecondActivity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SecondActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity","onDestroy");
    }
}