package com.example.rodolfo.inlocoweather;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private LatLng markerLatLng;
    private Button buscarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        buscarButton = (Button) findViewById(R.id.buscarButton);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        mMap.setOnMapLongClickListener(mapLongListener);
        buscarButton.setOnClickListener(buttonListener);
    }

    //Acao para marcar o mapa
    GoogleMap.OnMapLongClickListener mapLongListener = new GoogleMap.OnMapLongClickListener() {
        @Override
        public void onMapLongClick(LatLng latLng) {
            mMap.clear();
            markerLatLng = latLng;
            mMap.addMarker(new MarkerOptions().position(latLng));
        }
    };
    //Acao ao apertar o botao buscar
    Button.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            GetData getData = new GetData();
            getData.execute(markerLatLng);
            ArrayList<Cidade> cidades = new ArrayList<>();
            try {
                cidades = getData.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            Singleton singleton = Singleton.getInstance();
            singleton.arrayList = cidades;

            Intent intent = new Intent(MapsActivity.this,List.class);
            startActivity(intent);

            //Toast toast = Toast.makeText(getApplicationContext(),cidades.get(0).getNome() + "" , Toast.LENGTH_LONG);
            //toast.show();
        }
    };
}
