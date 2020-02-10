package com.example.entregafinal.View;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.entregafinal.R;
import com.example.entregafinal.View.Adapter.PostsAdapter;
import com.example.entregafinal.View.Controller.PostsController;
import com.example.entregafinal.View.Model.POJO.Posts;
import com.example.entregafinal.View.Util.ResultListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    List<Posts> listaDePosts = new ArrayList<>();

    PostsController postsController;

    RecyclerView recyclerViewPosts;

    PostsAdapter postsAdapter;



    Context context;


    public MainFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        recyclerViewPosts = view.findViewById(R.id.reciclerViewPosts);

        postsController = new PostsController();



        ResultListener<List<Posts>> EscuchadorActivityPost = new ResultListener<List<Posts>>() {
            @Override
            public void finish(List<Posts> resultado) {

                for (Posts posts : resultado) {

                    listaDePosts.add(posts);



                    postsAdapter = new PostsAdapter(context,listaDePosts);
                    recyclerViewPosts.setAdapter(postsAdapter);

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
                    recyclerViewPosts.setLayoutManager(layoutManager);

                }

            }
        };


        postsController.buscarPosts(EscuchadorActivityPost);


        return view;
    }

}
