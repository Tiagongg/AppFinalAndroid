package com.example.entregafinal.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.entregafinal.R;
import com.google.android.material.navigation.NavigationView;

public class LoggedActivity extends AppCompatActivity {

    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);


        navigationView = findViewById(R.id.navigationView);
        ListenerDelNavigationView listenerDelNavigationView = new ListenerDelNavigationView();
        navigationView.setNavigationItemSelectedListener(listenerDelNavigationView);

    }


    private class ListenerDelNavigationView implements NavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            selectedMenuItem(menuItem);
            return true;
        }
    }

    private void selectedMenuItem(MenuItem item){
        if (item.getItemId() == R.id.login){
            Intent intent = new Intent(this, LoggedActivity.class);
            startActivity(intent);

        } else if (item.getItemId() == R.id.about) {
            Intent intent = new Intent(this,AboutUs.class);
            startActivity(intent);
        }


    }



}
