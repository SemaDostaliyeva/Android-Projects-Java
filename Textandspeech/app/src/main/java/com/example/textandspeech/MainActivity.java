package com.example.textandspeech;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity{
    EditText editText;
    TextView textView;
    Button writeButton, speakButton, notificationButton;
    TextToSpeech textToSpeech;
    boolean ttsStatus=false;
    String inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textview);
        writeButton = findViewById(R.id.write_button);
        speakButton = findViewById(R.id.speak_button);
        notificationButton = findViewById(R.id.notification_button);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                ttsStatus = status == TextToSpeech.SUCCESS;
            }
        });

        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ttsStatus){
                    textToSpeech.setLanguage(Locale.ENGLISH);
                    textToSpeech.speak(editText.getText().toString() , TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak now");
                startActivityForResult(intent, 4444);
            }
        });

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("notification", "notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText = textView.getText().toString().trim();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "notification")
                        .setContentTitle("Text to speech")
                        .setContentText(inputText)
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.ic_baseline_notifications_24);


                Notification notification = builder.build();
                NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0, notification);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 4444 && resultCode == RESULT_OK){
            textView.setText(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).get(0));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}

