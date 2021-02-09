package com.example.daggerimp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;


import okhttp.DaggerMyComponent;
import okhttp.HttpObject;
import presenter.DaggerPresenterComponent;
import presenter.Presenter;
import presenter.PresenterComponent;
import user.DaggerUserComponent;
import user.HttpModule;
import user.UserComponent;
import user.UserModule;

/**
 * Multiply component use dependency
 * Multiply Module use include
 * When has parameter, init DaggerComponent with Parameter
 * Different Component can't have the same scope
 */
public class MainActivity extends AppCompatActivity {
    String TAG="MainActivity";
    @Inject
    HttpObject httpObject;
    @Inject
    String user;

    @Inject
    Presenter presenter;

    @Inject
    int width;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //可以用这段代码 创建一个DaggerMyComponent单例模式
        UserComponent userComponent =DaggerUserComponent.builder().userModule(new UserModule(MainActivity.this)).build();
        PresenterComponent presenterComponent = DaggerPresenterComponent.create();
        DaggerMyComponent.builder().userComponent(userComponent).presenterComponent(presenterComponent).build().inject(MainActivity.this);


        Log.i(TAG,httpObject.hashCode()+"");
        Log.i(TAG,user);
        Log.i(TAG,presenter.hashCode()+"");
        Log.i(TAG,width+"");
        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
//        startActivity(intent);

    }
}