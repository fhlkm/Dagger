package com.example.daggerimp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;


import okhttp.DaggerMyComponent;
import okhttp.HttpObject;

public class SecondActivity extends AppCompatActivity {
    String TAG="SecondActivity";

    @Inject
    HttpObject httpObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG,httpObject.hashCode()+"");
    }
}
