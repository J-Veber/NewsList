package com.example.veber.newslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import org.json.JSONException;


public class ActivityMain extends AppCompatActivity {
    LinearLayout contentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentContainer = (LinearLayout) findViewById(R.id.content_container);
/*
        NewsRestClientUsage _newsRestClientUsage = new NewsRestClientUsage();
        try {
            _newsRestClientUsage.getNews();
        } catch (JSONException e) {
            e.printStackTrace();
        }
*/
        News news1 = new News("1","1","1","1","1","1");
        this.showOneNews(news1);
        this.showOneNews(news1);
        this.showOneNews(news1);
        this.showOneNews(news1);
        this.showOneNews(news1);
        this.showOneNews(news1);
    }

    protected void showOneNews(News news) {
        LinearLayout newNewsView = news.getView(getLayoutInflater());
        contentContainer.addView(newNewsView);
    }
}
