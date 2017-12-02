package com.example.binyamin.android5778_0445_7734_01.model.datasource;

import android.content.ContentValues;
import android.util.Log;

import com.example.binyamin.android5778_0445_7734_01.model.backend.Academy_Const;
import com.example.binyamin.android5778_0445_7734_01.model.backend.DB_manager;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Branch;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Car;
import com.example.binyamin.android5778_0445_7734_01.model.entities.CarModel;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Client;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by binyamin on 01/12/2017.
 */

public class MySQL_DBManager implements DB_manager {

    private String WEB_URL = "obinyami.vlab.jct.ac.il/Academy/";



    @Override
    public long addClient(ContentValues values) {

      try
      {
          String result = PHPtools.POST(WEB_URL+ "/add_client.php", values);
          long id = Long.parseLong(result);

          Log.i("addClient: " , result);
          return id;



      }
        catch (Exception e )
        {
            Log.e("addClientException: \n" , e.toString());
            return  -1;
        }
            }

    @Override
    public boolean isClientExist(long id) {
        return false;
    }

    @Override
    public List<Client> getClients() {
        List<Client> result = new ArrayList<>();
        try
        {
            String str = PHPtools.GET(WEB_URL + "getClientList.php");
            JSONArray array = new  JSONObject(str).getJSONArray("clientList");

            JSONObject jsonObject;
            ContentValues contentValues;
            Client client;

            for (int i = 0 ; i < array.length(); i++)
            {
                jsonObject = array.getJSONObject(i);
                contentValues = PHPtools.JsonToContentValues(jsonObject);
                client = Academy_Const.ContentValuesToClient(contentValues);

                result.add(client);



            }
            return result;


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long addCarModel(ContentValues carModel) {
        return 0;
    }

    @Override
    public List<CarModel> getCarModels() {
        return null;
    }

    @Override
    public long addCar(ContentValues car) {
        return 0;
    }

    @Override
    public List<Car> getCars() {
        return null;
    }

    @Override
    public List<Branch> getBranchs() {
        return null;
    }
}
