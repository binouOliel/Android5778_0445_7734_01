package com.example.binyamin.android5778_0445_7734_01.controller;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.binyamin.android5778_0445_7734_01.R;
import com.example.binyamin.android5778_0445_7734_01.model.backend.Academy_Const;
import com.example.binyamin.android5778_0445_7734_01.model.datasource.List_DBManager;
import com.example.binyamin.android5778_0445_7734_01.model.entities.BRAND;
import com.example.binyamin.android5778_0445_7734_01.model.entities.DOOR;
import com.example.binyamin.android5778_0445_7734_01.model.entities.LUGGAGE;
import com.example.binyamin.android5778_0445_7734_01.model.entities.PASSENGERS;

public class AddCarModelActivity extends AppCompatActivity implements View.OnClickListener{

    private Switch   airCSwitch;
    private Switch   automaticSwitch;
    private EditText nameCarModelEditText;
    private Spinner  brandSpinner;
    private Spinner  lugageSpinner;
    private Spinner  passengerSpinner;

    private TextView doorTextView;
    private Button   addButton;
    private ImageButton   downButton;
    private ImageButton   upButton;
    
    List_DBManager list_dbManager = List_DBManager.getInstance();

    private void upButtonClick()
    {
        int value = Integer.parseInt(doorTextView.getText().toString());

        if (value < 5)
        {
            value++;
            doorTextView.setText(value);
        }


    }
    private void downButtonClick () {

        int value = Integer.parseInt(doorTextView.getText().toString());

        if (value > 1)
        {
            value--;
            doorTextView.setText(value);
        }

    }



    private void getViews()
    {
        airCSwitch = (Switch)findViewById(R.id.AirCSwitch);
        automaticSwitch = (Switch)findViewById(R.id.automaticSwitch) ;
        nameCarModelEditText= (EditText)findViewById(R.id.nameModelCarEdittext);
        brandSpinner = (Spinner)findViewById(R.id.brandSpinner) ;
        lugageSpinner = (Spinner)findViewById(R.id.lugageSpinner);
        passengerSpinner = (Spinner)findViewById(R.id.passengerSpinner);

        doorTextView = (TextView) findViewById(R.id.volumetextView);
        addButton = (Button)findViewById(R.id.addButton);
        downButton = (ImageButton)findViewById(R.id.downButton);
        upButton = (ImageButton)findViewById(R.id.upButton);
    }

    private void setOnClickListeners() {
        if (addButton != null) {
            addButton.setOnClickListener(this);

            downButton.setOnClickListener(this);
            upButton.setOnClickListener(this);
        }
    }

    private void initActivity()
    {
        getViews();
        setOnClickListeners();
        populateSpinners();
    }

    private void populateSpinners()
    {
        ArrayAdapter<BRAND> adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, BRAND.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brandSpinner.setAdapter(adapter);
        brandSpinner.setPrompt("Brand");

        ArrayAdapter<LUGGAGE> adapter1 =  new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, LUGGAGE.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lugageSpinner.setAdapter(adapter1);
        lugageSpinner.setPrompt("Lugage");

        ArrayAdapter<PASSENGERS> adapter2 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, PASSENGERS.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        passengerSpinner.setAdapter(adapter2);
        passengerSpinner.setPrompt("Passengers");

        ArrayAdapter<DOOR> adapter3 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, DOOR.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        doorSpinner.setAdapter(adapter3);
        doorSpinner.setPrompt("Color");


    }

    private void  addCarModel()
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(Academy_Const.CarModelConst.COMPANY_NAME , brandSpinner.getSelectedItem().toString());
        contentValues.put(Academy_Const.CarModelConst.LUGAGE_COMPARTMENT, lugageSpinner.getSelectedItem().toString());
        contentValues.put(Academy_Const.CarModelConst.AIR_C, airCSwitch.isChecked());
        contentValues.put(Academy_Const.CarModelConst.IS_AUTOMATIC, automaticSwitch.isChecked());
        contentValues.put(Academy_Const.CarModelConst.MODEL_NAME, nameCarModelEditText.getText().toString());
        //contentValues.put(Academy_Const.CarModelConst.DOOR, doorSpinner.getSelectedItem().toString());
        contentValues.put(Academy_Const.CarModelConst.DOOR, doorTextView.getText().toString());
        contentValues.put(Academy_Const.CarModelConst.PASSENGERS, passengerSpinner.getSelectedItem().toString());



        new Task.AddCarModelTask(this).execute(contentValues);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_model);
        initActivity();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.addButton:
                addCarModel();
                refreshInputsText();
                break;
            case R.id.downButton:
                downButtonClick();
                break;
            case R.id.upButton:
                upButtonClick();
                break;



        }
    }

    private void refreshInputsText() {
        airCSwitch.setChecked(false);
        automaticSwitch.setChecked(false);
        nameCarModelEditText.setText(null);
        brandSpinner.setSelection(0);
        lugageSpinner.setSelection(0);
        passengerSpinner.setSelection(0);
        //doorSpinner.setSelection(0);
        doorTextView.setText(0);

    }
}
