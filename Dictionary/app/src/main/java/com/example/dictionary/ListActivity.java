package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView listview;
    SQLiteDatabase sqLiteDatabase;
    DatabaseHandler databaseHandler;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listview = findViewById(R.id.listview);
        databaseHandler = new DatabaseHandler(this);
        databaseHandler.realAllData();
        MyListAdapter arrayAdapter = new MyListAdapter(ListActivity.this, R.layout.activity_list_item);
        listview.setAdapter(arrayAdapter);
    }



}