package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmailActivity extends AppCompatActivity {
    EditText input_email;
    Button second_mail;
    Intent intent_mail_start;
    Uri mail;
    String mail_str;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        input_email  = findViewById(R.id.input_email);
        second_mail = findViewById(R.id.second_mail);

        second_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mail_str = input_email.getText().toString().trim();
                if (mail_str.equals("")) {
                    toast = Toast.makeText(getApplicationContext(), "Please fill the input", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    mail = Uri.parse("mailto:"+mail_str);
                    intent_mail_start = new Intent(Intent.ACTION_SENDTO, mail);
                    startActivity(intent_mail_start);
                }
            }
        });

    }
}