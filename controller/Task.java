package com.example.binyamin.android5778_0445_7734_01.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.binyamin.android5778_0445_7734_01.R;
import com.example.binyamin.android5778_0445_7734_01.model.datasource.List_DBManager;
import com.example.binyamin.android5778_0445_7734_01.model.entities.CarModel;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by binyamin on 21/11/2017.
 */
 class Task
{
    static List_DBManager list_dbManager = List_DBManager.getInstance();


   static class ClientListTask extends AsyncTask< Integer, Void , List<Client>> {
       private Activity context;

       ClientListTask(Activity context) {
           this.context = context;
       }

       @Override
        protected List<Client> doInBackground(Integer... choice) {
            return list_dbManager.getClients();
        }

       @Override
       protected void onPostExecute(List<Client> clientList) {
           ArrayList<Client> clientArrayList = new ArrayList<Client>(clientList);

           ClientAdapter itemAdapter =
                   new ClientAdapter(context , clientArrayList );
           ListView listView = (ListView)context.findViewById(R.id.rootView);
           listView.setAdapter(itemAdapter);
       }
    }

   static class CarModelListTask extends AsyncTask<Void, Void , List<CarModel>>
    {
        private Activity context;

        public CarModelListTask(Activity context) {
            this.context = context;
        }

        @Override
        protected List<CarModel> doInBackground(Void... choice) {

            return list_dbManager.getCarModels();
        }

        @Override
        protected void onPostExecute(List<CarModel> carModels) {
            ArrayList<CarModel> carModelArrayList = new ArrayList<CarModel>(carModels);

            CarModelAdapter itemAdapter =
                    new CarModelAdapter(context , carModelArrayList );
            ListView listView = (ListView)context.findViewById(R.id.rootView);
            listView.setAdapter(itemAdapter);
        }
    }

  static    class AddClientTask extends AsyncTask<ContentValues , Void , Long>
    {
        private Context context;
        public AddClientTask(Context context) {
            this.context = context;

        }

        @Override
        protected Long doInBackground(ContentValues... contentValues) {

            if(contentValues[0] != null)
            return list_dbManager.addClient(contentValues[0]);

            else
                return null;
        }

        @Override
        protected void onPostExecute(Long idCarmodel) {
            if(idCarmodel != null)


                Toast.makeText( context, "Client IdNumber: " + idCarmodel.toString() +
                                " created",
                        Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context, "Error adding client",
                        Toast.LENGTH_SHORT).show();
        }


    }

  static    class AddCarModelTask extends AsyncTask<ContentValues, Void, Long>
    {
        private Context context;

        public AddCarModelTask(Context context) {
            this.context = context;
        }

        @Override
        protected Long doInBackground(ContentValues... contentValues) {
            if(contentValues[0] != null)
                return list_dbManager.addCarModel(contentValues[0]);

            else
                return null;
        }
        @Override
        protected void onPostExecute(Long idCarmodel) {
            if(idCarmodel != null)


                Toast.makeText( context, "Car Model IdNumber: " + idCarmodel.toString() +
                                " created",
                        Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context, "Error adding Car Model",
                        Toast.LENGTH_SHORT).show();
        }
    }

}

