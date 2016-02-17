package com.example.rodolfo.inlocoweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Rodolfo on 2/17/2016.
 */
public class CidadeDetails extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cidade_details);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();

        //Link das views

        TextView nameDetails = (TextView) findViewById(R.id.nameDetails);
        TextView tempMax = (TextView) findViewById(R.id.tempMax);
        TextView tempMin = (TextView) findViewById(R.id.tempMin);
        TextView description = (TextView) findViewById(R.id.description);

        //Colocando os dados nas respectivas views

        nameDetails.setText(intent.getCharSequenceExtra("name"));
        tempMax.setText("Temperatura maxima: " + intent.getDoubleExtra("tempMax",0) + "ºC");
        tempMin.setText("Temperatura minina: " + intent.getDoubleExtra("tempMin",0) + "ºC") ;
        description.setText("Descricao do tempo: " + intent.getCharSequenceExtra("description"));
    }
}
