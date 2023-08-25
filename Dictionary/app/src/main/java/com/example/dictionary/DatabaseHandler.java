package com.example.dictionary;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;
    public static final String DB_NAME = "dictionary";
    public static final int DB_VERSION = 1;
    Cursor cursor;
    ArrayList<String> stringArrayList;

    public DatabaseHandler(@Nullable Context context) {
        super(context,DB_NAME,null ,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String dictionary_table = "Create table dictionary_table(first_word text, meaning_word text)";
        db.execSQL(dictionary_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS dictionary_table");
        onCreate(db);
    }

    public boolean insertData(String word1 , String word2){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_word" , word1);
        contentValues.put("meaning_word" , word2);
        long result= sqLiteDatabase.insert("dictionary_table" , null , contentValues);
        if(result>0)return true;
        return false;
    }

    @SuppressLint("Range")
    public String selectData(String word){
        sqLiteDatabase = this.getReadableDatabase();
        cursor = sqLiteDatabase.rawQuery( "select * from dictionary_table where first_word = ? Collate NOCASE"  , new String[]{word} );
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            return cursor.getString(cursor.getColumnIndex("meaning_word"));
        }
        return "tapilmadi";
    }

    public void realAllData() {
        SQLiteDatabase db = this.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM dictionary_table"  ,null);
        MyListAdapter.first_word_array.clear();
        MyListAdapter.second_word_array.clear();
        while (cursor.moveToNext()) {

            MyListAdapter.first_word_array.add(cursor.getString(cursor.getColumnIndexOrThrow("first_word")));
            MyListAdapter.second_word_array.add(cursor.getString(cursor.getColumnIndexOrThrow("meaning_word")));
        }
        cursor.close();
    }


}
