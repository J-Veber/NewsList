package com.example.veber.newslist;

import android.view.View;
import android.widget.Toast;

import java.util.List;


public class SavedNews extends NewsListActivity {

    @Override
    protected void buttonAction(){
        finish();
    }

    @Override
    protected void loadData() {

        List<News> news = News.listAll(News.class);

        if (news.size() > 0) {
            for (News cur_news: news) {
                View newsView = cur_news.getView(getLayoutInflater(), getApplicationContext());
                cur_news.setDeleteListner(getApplicationContext());
                showOneNews(newsView);
            }
        } else if (news.size() == 0) {
            Toast.makeText(this, "You have not any saved news", Toast.LENGTH_SHORT).show();
        }
    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_saved_news);
//
//        List<News> news = News.listAll(News.class);
//
//        if (news.size() > 0) {
//            for (News cur_news: news) {
//                View newsView = cur_news.getView(getLayoutInflater(), getApplicationContext());
//                cur_news.setDeleteListner(getApplicationContext());
//                showOneNews(newsView);
//            }
//        } else if (news.size() == 0) {
//            Toast.makeText(this, "You have not any saved news", Toast.LENGTH_SHORT).show();
//        }
//    }
}
