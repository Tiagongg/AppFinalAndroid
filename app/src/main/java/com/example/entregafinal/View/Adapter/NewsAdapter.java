package com.example.entregafinal.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.entregafinal.R;
import com.example.entregafinal.View.Model.POJO.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter {

    Context context;

    List<News> listaNews;

    public NewsAdapter(Context context, List<News> listaNews) {
        this.context = context;
        this.listaNews = listaNews;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View cell = inflater.inflate(R.layout.cellnews_layout,parent,false);

        ViewHolderItems viewHolderItems = new ViewHolderItems(cell);

        return viewHolderItems;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        News news = listaNews.get(position);
        NewsAdapter.ViewHolderItems viewholderItems = (NewsAdapter.ViewHolderItems) holder;
        viewholderItems.setDataProducts(news);

    }

    @Override
    public int getItemCount() {
        return listaNews.size();
    }

    private class ViewHolderItems extends RecyclerView.ViewHolder {


        TextView textViewAuthor;
        TextView textViewDescription;
        TextView textViewTitle;
        TextView textViewContent;

        public ViewHolderItems(@NonNull View itemView) {
            super(itemView);


            textViewAuthor = itemView.findViewById(R.id.textAuthor);
            textViewDescription = itemView.findViewById(R.id.textDescription);
            textViewTitle = itemView.findViewById(R.id.titleText);
            textViewContent = itemView.findViewById(R.id.textViewcontent);


        }

        public void setDataProducts(News news) {
            if (news.getAuthor() == null){

            } else{
                textViewAuthor.setText(news.getAuthor().toString());
            }

            textViewDescription.setText(news.getDescription().toString());
            textViewTitle.setText(news.getTitle().toString());

            if (news.getContent() == null){

            } else{
                textViewContent.setText(news.getContent().toString());
            }

        }


    }


}
