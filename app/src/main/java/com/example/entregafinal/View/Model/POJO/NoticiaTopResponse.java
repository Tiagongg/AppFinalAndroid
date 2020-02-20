package com.example.entregafinal.View.Model.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NoticiaTopResponse {

    @SerializedName("articles")
    List<News> listaNews;

    public List<News> getListaNews() {
        return listaNews;
    }
}
