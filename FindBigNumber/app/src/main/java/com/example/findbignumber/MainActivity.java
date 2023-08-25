package com.example.findbignumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtPoint;
    Button btnfirst;
    Button btnsecond;
    int point=0;
    int number1 , number2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RandomMethod();
    }
    private void RandomMethod(){
        txtPoint = (TextView) findViewById(R.id.textViewPoint);
        btnfirst = (Button)findViewById(R.id.btn1);
        btnsecond = (Button)findViewById(R.id.btn2);

        Random rand = new Random();
        number1=rand.nextInt(100)+1;
        number2=rand.nextInt(100)+1;
        btnfirst.setText(number1+"");
        btnsecond.setText(number2+"");
    }

    public void onClickLeft(View view) {
        if(number1>number2){
            point++;
        }
        else{
            point--;
        }
        txtPoint.setText("Points: " + point);
        RandomMethod();
    }

    public void onClickRight(View view) {
        if(number2>number1){
            point++;
        }
        else {
            point--;
        }
        txtPoint.setText("Points: " + point);
        RandomMethod();
    }
}