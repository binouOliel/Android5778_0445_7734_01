package com.example.binyamin.android5778_0445_7734_01.controller;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.binyamin.android5778_0445_7734_01.R;
import com.example.binyamin.android5778_0445_7734_01.model.entities.CarModel;

import java.util.ArrayList;

/**
 * Created by binyamin on 20/11/2017.
 */

public class CarModelAdapter extends ArrayAdapter<CarModel> {

    public CarModelAdapter(Activity context, ArrayList<CarModel> carModelArrayList) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, carModelArrayList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView1 = convertView;

        if(listItemView1 == null) {
            listItemView1 = LayoutInflater.from(getContext()).inflate(
                    R.layout.car_model_list_item, parent, false);
        }

        final View  listItemView = listItemView1;

        // Get the {@link currentCarModel} object located at this position in the list
        CarModel currentCarModel = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name

        TextView SlugageTextView = (TextView) listItemView.findViewById(R.id.smalLugTextView);
        TextView BlugageTextView = (TextView) listItemView.findViewById(R.id.smalLugTextView);


        TextView passengerTextView = (TextView) listItemView.findViewById(R.id.passengerTextView);
        TextView fuelTextView = (TextView) listItemView.findViewById(R.id.fueltextView);
        TextView AcTextView = (TextView) listItemView.findViewById(R.id.ACtextView);
        TextView gearBoxTextBox = (TextView) listItemView.findViewById(R.id.gearBoxtextView);
        TextView doorTextView = (TextView) listItemView.findViewById(R.id.doorTextView);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.nametextView);
        TextView brandTextView = (TextView) listItemView.findViewById(R.id.brandTextView);
        TextView idTextView = (TextView) listItemView.findViewById(R.id.idtextView);

        // Get the version name from the current Word object and
        // set this text on the name TextView

        nameTextView.setText(currentCarModel.getModelName());
        brandTextView.setText(currentCarModel.getModelCompanyName());
        idTextView.setText( String.valueOf(currentCarModel.getModelId()) );

        passengerTextView.setText(currentCarModel.getPassengers().toString());
       // fuelTextView.setText(currentCarModel.getModelMotorVolume());


        if (currentCarModel.isAirC())
            AcTextView.setText("YES");
        else
            AcTextView.setText("NO");

        if (currentCarModel.isAutomatic())
            gearBoxTextBox.setText("AUTOMATIC");
        else gearBoxTextBox.setText("MANUAL");

        switch(currentCarModel.getDoor())
        {
            case TWO: doorTextView.setText("2 doors");
                break;
            case THREE: doorTextView.setText("3 doors");
                break;
            case FOUR: doorTextView.setText("4 doors");
                break;
            case FIVE: doorTextView.setText("5 doors");
                break;
        }

        switch(currentCarModel.getLuggageCompartment())
        {
            case SMALL: SlugageTextView.setText("2");
                        BlugageTextView.setText("1");
                break;
            case MID:SlugageTextView.setText("4");
                     BlugageTextView.setText("2");
                break;
            case BIG:SlugageTextView.setText("6");
                     BlugageTextView.setText("5");
                break;
        }

        listItemView.findViewById(R.id.generalLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItemView.findViewById(R.id.generalLayout).setVisibility(View.GONE);
                listItemView.findViewById(R.id.detailsLayout).setVisibility(View.VISIBLE);

            }
        });

        listItemView.findViewById(R.id.detailsLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItemView.findViewById(R.id.generalLayout).setVisibility(View.VISIBLE);
                listItemView.findViewById(R.id.detailsLayout).setVisibility(View.GONE);
            }
        });







        // Return the whole list item layout (containing 5 TextViews)
        // so that it can be shown in the ListView
        return listItemView;    }
}
