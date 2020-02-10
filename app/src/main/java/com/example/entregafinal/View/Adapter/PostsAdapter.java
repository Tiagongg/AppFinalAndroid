package com.example.entregafinal.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.entregafinal.R;
import com.example.entregafinal.View.Model.POJO.Posts;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter {
    Context context;
    List<Posts> listadePosts;


    public PostsAdapter(Context context, List<Posts> listadePosts) {
        this.context = context;
        this.listadePosts = listadePosts;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View cell = inflater.inflate(R.layout.cellposts_layout,parent,false);

        ViewHolderItems viewHolderItems = new ViewHolderItems(cell);


        return viewHolderItems;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Posts posts = listadePosts.get(position);
        ViewHolderItems viewholderItems = (ViewHolderItems) holder;
        viewholderItems.setDataProducts(posts);

    }

    @Override
    public int getItemCount() {
        return listadePosts.size();
    }



    private class ViewHolderItems extends RecyclerView.ViewHolder {


        TextView textViewUserId;
        TextView textViewId;
        TextView textViewTitle;
        TextView textViewBody;

        public ViewHolderItems(@NonNull View itemView) {
            super(itemView);


            textViewUserId = itemView.findViewById(R.id.userID);
            textViewId = itemView.findViewById(R.id.postID);
            textViewTitle = itemView.findViewById(R.id.titleText);
            textViewBody = itemView.findViewById(R.id.bodyText);


        }

        public void setDataProducts(Posts posts) {
            textViewUserId.setText(posts.getUserId().toString());
            textViewId.setText(posts.getId().toString());
            textViewTitle.setText(posts.getTitle().toString());
            textViewBody.setText(posts.getBody().toString());
        }


    }

}
