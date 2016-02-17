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

        TextView nameDetails = (TextView) findViewById(R.id.nameDetails);
        TextView tempMax = (TextView) findViewById(R.id.tempMax);
        TextView tempMin = (TextView) findViewById(R.id.tempMin);
        TextView description = (TextView) findViewById(R.id.description);

        nameDetails.setText(intent.getCharSequenceExtra("name"));
        tempMax.setText(intent.getDoubleExtra("tempMax",0) + "");
        tempMin.setText(intent.getDoubleExtra("tempMin",0) + "") ;
        description.setText(intent.getCharSequenceExtra("description"));
    }
}
