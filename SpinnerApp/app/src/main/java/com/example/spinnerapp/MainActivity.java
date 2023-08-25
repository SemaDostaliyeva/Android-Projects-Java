package com.example.spinnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    Spinner spinner;
    ImageView image;
    String [] string_arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=(Spinner) findViewById(R.id.spinner);
        image=(ImageView) findViewById(R.id.Img);
        string_arr=getResources().getStringArray(R.array.Planets);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               switch (i+1){
                   case 1: image.setImageResource(R.drawable.saturn);
                   break;
                   case 2: image.setImageResource(R.drawable.venera);
                   break;
                   case 3: image.setImageResource(R.drawable.pluton);
                   break;
                   case 4: image.setImageResource(R.drawable.merkuri);
                   break;
                   case 5: image.setImageResource(R.drawable.yer);
                   break;
                   case 6: image.setImageResource(R.drawable.neptun);
                   break;
                   case 7: image.setImageResource(R.drawable.uran);
                   break;
                   case 8: image.setImageResource(R.drawable.mars);
                   break;
                   case 9: image.setImageResource(R.drawable.yupiter2);
                   break;
               }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}