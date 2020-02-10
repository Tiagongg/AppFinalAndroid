package com.example.entregafinal.View.Model.DAO;

import com.example.entregafinal.View.Model.POJO.Posts;
import com.example.entregafinal.View.Services.ServicePost;
import com.example.entregafinal.View.Util.ResultListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DAOPostsRetrofit {

    private Retrofit retrofit;
    private ServicePost servicePost;
    private String baseURL;

    List<Posts> listaPosts = new ArrayList<>();




    public DAOPostsRetrofit() {

        baseURL = "https://jsonplaceholder.typicode.com/";

        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        servicePost = retrofit.create(ServicePost.class);
    }



    public void getAllPosts(final ResultListener<List<Posts>> escuchadorDelPostsController)  {



        Call<List<Posts>> postsCallback = servicePost.getPosts();
        postsCallback.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {

                escuchadorDelPostsController.finish(response.body());

            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {



            }

        });



    }

}
