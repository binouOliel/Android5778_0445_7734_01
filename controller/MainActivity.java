package com.example.binyamin.android5778_0445_7734_01.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.binyamin.android5778_0445_7734_01.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // declare All the view in the activity
    private Button addClientButton;
    private Button displayClientListButton;
    private Button addCarModelButton;
    private Button displayCarModelButton;

    //instance of each view by id of the activity
    private void findViews()
    {
        addClientButton = (Button)findViewById(R.id.addClientbutton);
        displayClientListButton = (Button)findViewById(R.id.displayListClientbutton);
        addCarModelButton = (Button)findViewById(R.id.addModelCar);
        displayCarModelButton = (Button)findViewById(R.id.displayListCarmodel);
    }

    private void addClientIntent()
    {
        Intent intent = new Intent(this, AddClientActivity.class);
        startActivity(intent);
    }
    private void addCarModelIntent()
    {
        Intent intent = new Intent(this, AddCarModelActivity.class);
        startActivity(intent);
    }
    private void displayClientListIntent()
    {
        Intent intent = new Intent(this, ClientListActivity.class);
        startActivity(intent);
    }

    private void displayCarModelListIntent()
    {
        Intent intent = new Intent(this, CarListActivity.class);
        startActivity(intent);
    }

    private void setOnClickListeners() {
        if (addClientButton != null) {
            addClientButton.setOnClickListener(this);
        }

        if (displayClientListButton != null) {
            displayClientListButton.setOnClickListener(this);
        }

        if(addCarModelButton != null)
        {
            addCarModelButton.setOnClickListener(this);
        }
        if(displayCarModelButton != null)
        {
            displayCarModelButton.setOnClickListener(this);
        }

    }

    private void initActivity()
    {
        // Call function that instance all the views.
        findViews();
        setOnClickListeners();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActivity();


    }

    @Override
    public void onClick(View v)
    {
        Log.i("IDView", String.valueOf((v.getId())));

        switch (v.getId()){

            case R.id.addClientbutton:
                    addClientIntent();
                break;

            case R.id.displayListClientbutton:
                    displayClientListIntent();
                break;
            case R.id.addModelCar:
                    addCarModelIntent();
                    break;

            case R.id.displayListCarmodel:
                displayCarModelListIntent();
                break;

        }
    }
}
