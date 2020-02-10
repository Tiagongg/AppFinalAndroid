package com.example.entregafinal.View.Services;

import com.example.entregafinal.View.Model.POJO.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicePost {

    @GET("/posts")
    Call<List<Posts>> getPosts();
}
