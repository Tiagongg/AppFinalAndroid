package com.example.entregafinal.View.Model.DAO;

import com.example.entregafinal.View.Model.POJO.News;
import com.example.entregafinal.View.Model.POJO.NewsEverything;
//import com.example.entregafinal.View.Model.POJO.NoticiaTopResponse;
import com.example.entregafinal.View.Model.POJO.NoticiaTopResponse;
import com.example.entregafinal.View.Services.ServicePost;
import com.example.entregafinal.View.Util.ResultListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DAONewsRetrofit {
    private Retrofit retrofit;
    private ServicePost servicePost;
    private String baseURL;

    String apiKey = "614e1adf9c1a4939a8b31b02876a2851";


    public DAONewsRetrofit() {

        baseURL = "https://newsapi.org/v2/";


        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        servicePost = retrofit.create(ServicePost.class);
    }


    public void getTopNews(final ResultListener<NoticiaTopResponse> escuchadorDelNewsController) {
        Call<NoticiaTopResponse> newsCallback = servicePost.getNews(apiKey,"us");
        newsCallback.enqueue(new Callback<NoticiaTopResponse>() {
            @Override
            public void onResponse(Call<NoticiaTopResponse> call, Response<NoticiaTopResponse> response) {
                escuchadorDelNewsController.finish(response.body());
            }

            @Override
            public void onFailure(Call<NoticiaTopResponse> call, Throwable t) {
                System.out.println("fallo");

            }
        });
    }

    public void getEverythingNews(final ResultListener<NewsEverything> escuchadorDelNewsController) {
        Call<NewsEverything> newsCallback = servicePost.getEverythingNews(apiKey,"bitcoin");
        newsCallback.enqueue(new Callback<NewsEverything>() {
            @Override
            public void onResponse(Call<NewsEverything> call, Response<NewsEverything> response) {
                escuchadorDelNewsController.finish(response.body());
            }

            @Override
            public void onFailure(Call<NewsEverything> call, Throwable t) {
                System.out.println("fallo");

            }
        });


    }





}
