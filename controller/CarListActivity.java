package com.example.binyamin.android5778_0445_7734_01.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.binyamin.android5778_0445_7734_01.R;

public class CarListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

       new Task.CarModelListTask(this).execute();
    }
}
