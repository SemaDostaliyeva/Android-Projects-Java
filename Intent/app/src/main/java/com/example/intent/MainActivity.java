package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intent_phone, intent_mail, intent_map, intent_url;
    Button btn_phone, btn_mail, btn_map, btn_url, btn_seacrh;
    TextView url_text_main;
    String url_text_str;
    Uri search_start;
    Intent search_start_intent;
    private static final int Req_code=4444;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_phone=findViewById(R.id.phone);
        btn_mail=findViewById(R.id.email);
        btn_map=findViewById(R.id.map);
        btn_url = findViewById(R.id.url);
        btn_seacrh=findViewById(R.id.search);
        url_text_main =findViewById(R.id.url_input_main);

        btn_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent_phone = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent_phone);
            }
        });

        btn_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent_mail = new Intent(MainActivity.this, EmailActivity.class);
                startActivity(intent_mail);
            }
        });

        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent_map = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent_map);
            }
        });

        btn_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent_url = new Intent(MainActivity.this, UrlActivity.class);
                startActivityForResult(intent_url, Req_code);
            }
        });

        btn_seacrh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url_text_str = url_text_main.getText().toString().trim();
                if (url_text_str.equals("")) {
                    toast = Toast.makeText(getApplicationContext(), "Please click the url input", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    search_start = Uri.parse("http://"+url_text_str);
                    search_start_intent = new Intent(Intent.ACTION_VIEW, search_start);
                    startActivity(search_start_intent);
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        MainActivity.super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == Req_code && resultCode==RESULT_OK) {
            String data = intent.getStringExtra("url_adress");
            url_text_main.setText(data);
        }
    }

}