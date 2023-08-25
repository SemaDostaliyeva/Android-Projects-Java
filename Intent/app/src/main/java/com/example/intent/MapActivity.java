package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MapActivity extends AppCompatActivity {
    EditText input_map;
    Button second_map;
    String map_str;
    Uri map;
    Intent intent_map_start;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        input_map = findViewById(R.id.input_map);
        second_map = findViewById(R.id.second_map);

        second_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map_str = input_map.getText().toString().trim();
                if (map_str.equals("")) {
                    toast = Toast.makeText(getApplicationContext(), "Please fill the input", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    map = Uri.parse("geo:"+map_str);
                    intent_map_start = new Intent(Intent.ACTION_VIEW,map);
                    startActivity(intent_map_start);
                }
            }
        });
    }
}