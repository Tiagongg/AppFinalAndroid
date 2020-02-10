package com.example.entregafinal.View.Controller;

import com.example.entregafinal.View.Model.DAO.DAOPostsRetrofit;
import com.example.entregafinal.View.Model.POJO.Posts;
import com.example.entregafinal.View.Util.ResultListener;

import java.util.List;

public class PostsController {

    DAOPostsRetrofit daoPostsRetrofit;


    public PostsController(){

    }

    public void buscarPosts(final ResultListener<List<Posts>> EscuchadorActivityPost) {

        daoPostsRetrofit = new DAOPostsRetrofit();


        ResultListener<List<Posts>> escuchadorDelPostsController = new ResultListener<List<Posts>>() {
            @Override
            public void finish(List<Posts> resultado) {
                EscuchadorActivityPost.finish(resultado);
            }
        };

        daoPostsRetrofit.getAllPosts(escuchadorDelPostsController);
    }
}
