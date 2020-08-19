package com.example.entregafinal.View;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.entregafinal.R;
import com.example.entregafinal.View.Adapter.NewsAdapter;
import com.example.entregafinal.View.Controller.NewsController;
import com.example.entregafinal.View.Model.POJO.News;
import com.example.entregafinal.View.Model.POJO.NewsEverything;
import com.example.entregafinal.View.Model.POJO.NoticiaTopResponse;
import com.example.entregafinal.View.Util.ResultListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EveryThingFragment extends Fragment implements NewsAdapter.EscuchadorFragment {


    NewsController newsController;

    RecyclerView recyclerViewNews;

    NewsAdapter newsAdapter;

    List<News> listadeNews = new ArrayList<>();

    EscuchadorActivity escuchadorActivity;


    Context context;


    public EveryThingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        escuchadorActivity = (EscuchadorActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_every_thing, container, false);


        recyclerViewNews = view.findViewById(R.id.reciclerViewNews);

        newsController = new NewsController();

        ResultListener<NewsEverything> EscuchadorActivityNews = new ResultListener<NewsEverything>() {
            @Override
            public void finish(NewsEverything resultado) {


                for (News news : resultado.getListaNewsEverything()) {

                    listadeNews.add(news);

                }

                newsAdapter = new NewsAdapter(EveryThingFragment.this::clickOnImagenNews,getContext(),listadeNews);
                recyclerViewNews.setAdapter(newsAdapter);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
                recyclerViewNews.setLayoutManager(layoutManager);

            }
        };

        newsController.getEverythingNews(EscuchadorActivityNews);



        return view;
    }

    @Override
    public void clickOnImagenNews(News news) {
        escuchadorActivity.clickOnNews(news);
    }

    public interface EscuchadorActivity{
        void clickOnNews(News news);
    }
}
