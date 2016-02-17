package com.example.rodolfo.inlocoweather;

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Rodolfo on 11/7/2015.
 */


public class GetData extends AsyncTask<LatLng, Void, ArrayList<Cidade>> {

    @Override
    protected ArrayList<Cidade> doInBackground(LatLng... latlng) {

        ArrayList<Cidade> cidades =  new ArrayList<>();

        String url = "http://api.openweathermap.org/data/2.5/find?lat=" + latlng[0].latitude + "&lon=" + latlng[0].longitude + "&cnt=15&units=metric&APPID=d5e5e7bf0036493556227d17d41219bd";
        try {
            JSONObject json = getJson(url);
            JSONArray list = json.getJSONArray("list");


            for (int i = 0; i < list.length(); i++) {
                String name = list.getJSONObject(i).get("name") + "";

                double tempMax = list.getJSONObject(i).getJSONObject("main").getDouble("temp_max");
                double tempMin = list.getJSONObject(i).getJSONObject("main").getDouble("temp_min");

                String description = list.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("description");
                Cidade tempCidade = new Cidade(name,tempMax,tempMin,description);
                cidades.add(tempCidade);

            }


        }catch (Exception e){
            e.printStackTrace();

    }

        return cidades;
    }

    public static JSONObject getJson(String url){

        InputStream is;
        String result;
        JSONObject jsonObject;

        // HTTP
        try {
            URL url2 = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) url2.openConnection();
            is = urlConnection.getInputStream();

        } catch(Exception e) {
            return null;
        }

        // Read response to string
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"utf-8"),8);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();
        } catch(Exception e) {
            return null;
        }

        // Convert string to object
        try {
            jsonObject = new JSONObject(result);
        } catch(JSONException e) {
            return null;
        }

        return jsonObject;

    }
}
