package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IncludeWords extends AppCompatActivity {

    TextView paragraph;
    EditText first ,second;
    String first_word , second_word;
    Button include_button;
    DatabaseHandler databaseHandler;
    DatabaseHandler db = new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_include_words);
        paragraph = findViewById(R.id.paragraph);
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        include_button = findViewById(R.id.include_button);

        include_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first_word = first.getText().toString().trim();
                second_word = second.getText().toString().trim();
                databaseHandler = new DatabaseHandler(IncludeWords.this);
               boolean result= databaseHandler.insertData(first_word , second_word);
               if(result)
                Toast.makeText(IncludeWords.this,"Sözlər lüğətə əlavə olundu", Toast.LENGTH_SHORT).show();
               else
                   Toast.makeText(IncludeWords.this, "Insert error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}