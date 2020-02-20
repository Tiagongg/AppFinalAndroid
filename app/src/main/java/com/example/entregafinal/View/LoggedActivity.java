package com.example.entregafinal.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.entregafinal.R;
import com.example.entregafinal.View.Controller.NewsController;
import com.example.entregafinal.View.Model.DAO.DAONewsRetrofit;
import com.example.entregafinal.View.Model.POJO.News;
import com.example.entregafinal.View.Model.POJO.NoticiaTopResponse;
import com.example.entregafinal.View.Util.ResultListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class LoggedActivity extends AppCompatActivity {

//    NavigationView navigationView;
    FragmentManager fm;
    NewsController newsController;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);
//
//        newsController = new NewsController();
//
//
//        ResultListener<NoticiaTopResponse> EscuchadorActivityNews = new ResultListener<NoticiaTopResponse>() {
//            @Override
//            public void finish(NoticiaTopResponse resultado) {
//
//            }
//
//        };
//
//        newsController.getnews(EscuchadorActivityNews);
//
//        DAONewsRetrofit daoNewsRetrofit = new DAONewsRetrofit();
//        daoNewsRetrofit.getTopNews(EscuchadorActivityNews);


//        fm = getSupportFragmentManager();
//
//        EveryThingFragment everyThingFragment = new EveryThingFragment();
//
//
//
//
//
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//        fragmentTransaction.replace(R.id.fragmentContainer,everyThingFragment);
//        fragmentTransaction.commit();




        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);


        fm = getSupportFragmentManager();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

//            if (selectedFragment != null) {
//                Toast.makeText(LoggedActivity.this, "AAAAAAAAAAAAAAA", Toast.LENGTH_SHORT).show();
////                selectedFragment = new MainFragment();
//            } else if (item.getItemId() == R.id.country){
//                selectedFragment = new MainFragment();
//            }

            switch (item.getItemId()){
                case R.id.country:
                    selectedFragment = new MainFragment();
                    break;
                case R.id.everything:
                    selectedFragment = new EveryThingFragment();
                    break;
            }

            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer,selectedFragment);
            fragmentTransaction.commit();

            return true;

        }
    };

}
