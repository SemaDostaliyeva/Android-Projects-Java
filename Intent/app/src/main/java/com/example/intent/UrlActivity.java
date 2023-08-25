package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UrlActivity extends AppCompatActivity {
    EditText input_url;
    Button second_url;
    String data_url;
    Intent intent;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);
        input_url = findViewById(R.id.input_url);
        second_url = findViewById(R.id.second_url);

        second_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_url = input_url.getText().toString().trim();
                if (data_url.equals("")) {
                    toast = Toast.makeText(getApplicationContext(), "Please fill the input", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    intent = new Intent();
                    intent.putExtra("url_adress" , data_url);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });

    }
}