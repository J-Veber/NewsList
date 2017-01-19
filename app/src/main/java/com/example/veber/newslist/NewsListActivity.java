package com.example.veber.newslist;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import org.json.JSONException;

import java.util.List;


public class NewsListActivity extends AppCompatActivity {

    LinearLayout contentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentContainer = (LinearLayout) findViewById(R.id.content_container);

        ImageButton toSavedNews = (ImageButton) findViewById(R.id.imageButton);
        toSavedNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAction();
            }
        });
    }

    @Override
    protected void onStart() {

        super.onStart();
        loadData();
    }

    protected void loadData(){

        NewsRestClientUsage _newsRestClientUsage = new NewsRestClientUsage(this);
        try {
            _newsRestClientUsage.getNews();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void buttonAction(){

        Intent intent = new Intent(NewsListActivity.this, SavedNews.class);
        startActivity(intent);
    }

    public void showOneNews(View news) {

        contentContainer.addView(news);
    }
}
