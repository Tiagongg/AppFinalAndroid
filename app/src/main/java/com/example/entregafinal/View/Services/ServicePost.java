package com.example.entregafinal.View.Services;

import com.example.entregafinal.View.Model.POJO.NewsEverything;
import com.example.entregafinal.View.Model.POJO.NoticiaTopResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServicePost {


    @GET("top-headlines")
    Call<NoticiaTopResponse> getNews(@Query("apiKey") String apiKey,
                                     @Query("country")String country);

    @GET("everything")
    Call<NewsEverything> getEverythingNews(@Query("apiKey") String apiKey,
                                           @Query("language") String language,
                                           @Query("q")String word);

}
