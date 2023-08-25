package com.example.menuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    String tag="TAGGG";
    String S="functionSS";
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.phone:
                Log.v(tag , "Phone is calling");
                break;
            case R.id.camera:
                Log.v(tag , "Camera is started");
                break;
            case R.id.search:
                Log.v(tag , "Search is ready");
                break;
            case R.id.settings:
                Log.v(tag  , "Settings are active");
                break;
            case R.id.notifications:
                Log.v(tag , "Notifications are active");
                break;
            case R.id.support:
                Log.v(tag , "Support is active");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(S ,"Start olunur");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(S ,"Restart olunur");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(S ,"Resume olunur");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(S ,"Stop olunur");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(S ,"Pauza olunur");
    }

    @Override

    protected void onDestroy() {
        super.onDestroy();
        Log.v(S ,"Destroy olunur");
    }
}