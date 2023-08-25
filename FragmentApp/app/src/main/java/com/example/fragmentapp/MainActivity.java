package com.example.fragmentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemReselectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomMenuBar);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragments , new HomeFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.home:
                        fragment = (new HomeFragment());
                        break;
                    case R.id.market:
                        fragment = (new MarketFragment());
                        break;
                    case R.id.qr:
                        fragment = (new QrFragment());
                        break;
                    case R.id.services:
                        fragment = (new ServicesFragment());
                        break;
                    case R.id.more:
                        fragment = (new MoreFragment());
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragments , fragment).commit();
                return true;
            }

        });
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {

    }
}