package com.example.veber.newslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
    }
}
