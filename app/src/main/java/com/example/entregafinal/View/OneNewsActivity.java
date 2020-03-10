package com.example.entregafinal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.entregafinal.R;

public class OneNewsActivity extends AppCompatActivity {

    TextView textViewAuthor;
    TextView textViewDescription;
    TextView textViewTitle;
    TextView textViewContent;
    ImageView newsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_news);

        textViewAuthor = findViewById(R.id.textAuthor);
        textViewDescription = findViewById(R.id.textDescription);
        textViewTitle = findViewById(R.id.titleText);
        textViewContent = findViewById(R.id.textViewcontent);
        newsImageView = findViewById(R.id.newsImageView);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        String title = bundle.getString("title");
        String author = bundle.getString("author");
        String description = bundle.getString("description");
        String content = bundle.getString("content");
        String imagen = bundle.getString("imagen");

        textViewTitle.setText(title);


        if (author == null){

        } else{
            textViewAuthor.setText(author);
        }

        textViewDescription.setText(description);
        textViewTitle.setText(title);

        if (content == null){

        } else{
            textViewContent.setText(content);
        }

        String urlImage = imagen;


        Glide.with(this).load(urlImage).into(newsImageView);



    }
}
