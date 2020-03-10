package com.example.entregafinal.View.Controller;

import com.example.entregafinal.View.Model.DAO.DAONewsRetrofit;
import com.example.entregafinal.View.Model.POJO.NewsEverything;
import com.example.entregafinal.View.Model.POJO.NoticiaTopResponse;
import com.example.entregafinal.View.Util.ResultListener;

public class NewsController {

    DAONewsRetrofit daoNewsRetrofit;

    public NewsController(){

    }


    public void getnews(final ResultListener<NoticiaTopResponse> EscuchadorActivityNews) {

        daoNewsRetrofit = new DAONewsRetrofit();


        ResultListener<NoticiaTopResponse> escuchadorDelNewsController = new ResultListener<NoticiaTopResponse>() {
            @Override
            public void finish(NoticiaTopResponse resultado) {
                EscuchadorActivityNews.finish(resultado);
            }
        };

        daoNewsRetrofit.getTopNews(escuchadorDelNewsController);
    }

    public void getEverythingNews(final ResultListener<NewsEverything> EscuchadorActivityNews) {

        daoNewsRetrofit = new DAONewsRetrofit();


        ResultListener<NewsEverything> escuchadorDelNewsController = new ResultListener<NewsEverything>() {
            @Override
            public void finish(NewsEverything resultado) {
                EscuchadorActivityNews.finish(resultado);
            }
        };

        daoNewsRetrofit.getEverythingNews(escuchadorDelNewsController);
    }


}
