package com.example.entregafinal.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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

public class LoggedActivity extends AppCompatActivity implements MainFragment.EscuchadorActivity, EveryThingFragment.EscuchadorActivity {

//    NavigationView navigationView;
    FragmentManager fm;
    NewsController newsController;
    BottomNavigationView bottomNavigationView;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);




        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);


        fm = getSupportFragmentManager();

        MainFragment mainFragment = new MainFragment();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer,mainFragment);
        fragmentTransaction.commit();



    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

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

    @Override
    public void clickOnNews(News news) {

        String title = news.getTitle();
        String author = news.getAuthor();
        String description = news.getDescription();
        String content = news.getContent();
        String imagen = news.getUrlToImage();


        Intent intent = new Intent(this,OneNewsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("author", author);
        bundle.putString("description",description);
        bundle.putString("content", content);
        bundle.putString("imagen",imagen);

        intent.putExtras(bundle);

        startActivity(intent);



    }
}
