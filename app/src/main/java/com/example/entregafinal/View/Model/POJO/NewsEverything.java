package com.example.entregafinal.View.Model.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsEverything {

    @SerializedName("articles")
    List<News> listaNews;

    public List<News> getListaNewsEverything() {
        return listaNews;
    }
}
