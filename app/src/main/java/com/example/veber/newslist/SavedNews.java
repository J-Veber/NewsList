package com.example.veber.newslist;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SavedNews extends AppCompatActivity {

//    private NewsListActivity receiver_activity;
    LinearLayout contentContainer;

//    SavedNews (NewsListActivity activity) {
//        receiver_activity = activity;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_news);

        contentContainer = (LinearLayout) findViewById(R.id.content_container_saved_news);

        List<News> news = News.listAll(News.class);
        //List<News> news = new ArrayList<>();
        News news2 = News.findById(News.class, 0);
        News news1 = News.findById(News.class, 1);
//        if (news.size() > 0) {
//            for (News cur_news: news) {
//                LinearLayout newNewsView = cur_news.getView(getLayoutInflater(), this);
//                contentContainer.addView(newNewsView);
//            }
//        } else if (news.size() == 0) {
//            Toast.makeText(this, "You have not any saved news", Toast.LENGTH_SHORT).show();
//        }
        //showAllSavedNews(this, news);
    }

//    private void showAllSavedNews(Activity activity, List<News> news) {
//
//        if (news.size() > 0) {
//            for (News cur_news: news) {
//                receiver_activity.showOneNews(cur_news);
//            }
//        } else if (news.size() == 0) {
//            Toast.makeText(this, "You have not any saved news", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private void showonenews(News news) {
//        LinearLayout newNewsView = news.getView(getLayoutInflater(), this);
//        contentContainer.addView(newNewsView);
//    }
}
