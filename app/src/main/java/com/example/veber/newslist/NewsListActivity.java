package com.example.veber.newslist;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        NewsRestClientUsage _newsRestClientUsage = new NewsRestClientUsage(this);
        try {
            _newsRestClientUsage.getNews();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void showOneNews(News news) {
        LinearLayout newNewsView = news.getView(getLayoutInflater(), this);
        contentContainer.addView(newNewsView);
    }

    public void toSaveNews(View view) {
        Intent intent = new Intent(this, SavedNews.class);
        startActivity(intent);
    }
}
