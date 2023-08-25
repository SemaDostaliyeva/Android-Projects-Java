package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView includewords , meaningword , list;
    EditText words;
    Button search;
    Intent intent;
    DatabaseHandler databaseHandler;
    SQLiteDatabase sqLiteDatabase;
    String result="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        includewords = findViewById(R.id.includewords);
        meaningword = findViewById(R.id.meaningword);
        words = findViewById(R.id.words);
        search = findViewById(R.id.search);
        list = findViewById(R.id.list);

        databaseHandler = new DatabaseHandler(this);

        includewords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this , IncludeWords.class);
                startActivity(intent);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = databaseHandler.selectData(words.getText().toString().trim());
                meaningword.setText(result);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this , ListActivity.class);
                startActivity(intent);
            }
        });

    }
}