package com.example.veber.newslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;

import org.json.JSONException;

import cz.msebera.android.httpclient.Header;


public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NewsRestClientUsage _newsRestClientUsage = new NewsRestClientUsage();
        try {
            _newsRestClientUsage.getNews();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String json;
        //AllNews _allnews = new AllNews();
        Gson gson = new Gson();
        AllNews _allnews = gson.fromJson(json, AllNews.class);
    }
}
