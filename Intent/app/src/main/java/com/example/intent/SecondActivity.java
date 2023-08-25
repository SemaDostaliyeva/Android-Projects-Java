package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    EditText input_phone;
    Button second_phone;
    Uri number;
    String phone_str;
    Intent intent_phone_start;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        input_phone = findViewById(R.id.input_phone);
        second_phone = findViewById(R.id.second_phone);

        second_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone_str = input_phone.getText().toString().trim();
                if (phone_str.equals("")) {
                    toast = Toast.makeText(getApplicationContext(), "Please fill the input", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    number = Uri.parse("tel:"+phone_str);
                    intent_phone_start = new Intent(Intent.ACTION_DIAL, number);
                    startActivity(intent_phone_start);
                }
            }
        });
    }
}