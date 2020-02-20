package com.example.entregafinal.View;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.entregafinal.R;
import com.example.entregafinal.View.Adapter.NewsAdapter;
import com.example.entregafinal.View.Adapter.PostsAdapter;
import com.example.entregafinal.View.Controller.NewsController;
import com.example.entregafinal.View.Controller.PostsController;
import com.example.entregafinal.View.Model.POJO.News;
import com.example.entregafinal.View.Model.POJO.NoticiaTopResponse;
import com.example.entregafinal.View.Model.POJO.Posts;
import com.example.entregafinal.View.Util.ResultListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    NewsController newsController;

    RecyclerView recyclerViewNews;

    NewsAdapter newsAdapter;

    List<News> listadeNews = new ArrayList<>();



    Context context;


    public MainFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        recyclerViewNews = view.findViewById(R.id.reciclerViewNews);

        newsController = new NewsController();










        ResultListener<NoticiaTopResponse> EscuchadorActivityNews = new ResultListener<NoticiaTopResponse>() {
            @Override
            public void finish(NoticiaTopResponse resultado) {


                for (News news : resultado.getListaNews()) {

                    listadeNews.add(news);



                }
                    newsAdapter = new NewsAdapter(context,listadeNews);
                    recyclerViewNews.setAdapter(newsAdapter);

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
                    recyclerViewNews.setLayoutManager(layoutManager);

            }
        };


        newsController.getnews(EscuchadorActivityNews);


        return view;
    }

}
