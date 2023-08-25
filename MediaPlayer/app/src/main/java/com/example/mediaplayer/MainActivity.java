package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
public class MainActivity extends AppCompatActivity {

    ImageButton before_music , play_pause , next_music;
    MediaPlayer music;
    int[] music_arr = {R.raw.valse, R.raw.janemaryam, R.raw.abouttime};
    int arr_index = 0;
    String music_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        before_music = findViewById(R.id.before_music);
        play_pause = findViewById(R.id.play_pause);
        next_music = findViewById(R.id.next_music);
        play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(music!=null && music.isPlaying()){
                    pause();
                }
                else if(music!=null && !music.isPlaying()){
                    music.start();
                }
                else{
                    play();
                }
            }
        });

        next_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr_index < music_arr.length-1){
                    arr_index++;
                    if(music.isPlaying()){
                       music.pause();
                    }

                    create();
                }
                else {
                    arr_index = 0;
                }
            }
        });

        before_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr_index> 0){
                    arr_index--;
                }
                else {
                    arr_index= music_arr.length-1;
                }
                if(music.isPlaying()){
                    music.pause();
                }
                create();
            }
        });

    }


    public void create(){
        music = MediaPlayer.create(getApplicationContext() , music_arr[arr_index]);
        music.start();

    }

    public void play() {
        if(music == null){
           create();
        }
    }

    public void pause(){
        if(music != null){
            music.pause();
        }
    }

    public void stop(){
        if(music!=null){
            music.release();
            music = null;
        }
    }
}