package com.example.veber.newslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;


public class SavedNews extends AppCompatActivity {

    LinearLayout contentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_news);

        contentContainer = (LinearLayout) findViewById(R.id.content_container_saved_news);
        ImageButton IB_delete_news = (ImageButton)contentContainer.findViewById(R.id.imageButton_saveNews);
        IB_delete_news.setImageResource(android.R.drawable.ic_menu_delete);
        //IB.setVisibility(View.GONE);
        List<News> news = News.listAll(News.class);
        if (news.size() > 0) {
            for (News cur_news: news) {
                LinearLayout newNewsView = cur_news.getView(getLayoutInflater(), this);
                contentContainer.addView(newNewsView);
            }
        } else if (news.size() == 0) {
            Toast.makeText(this, "You have not any saved news", Toast.LENGTH_SHORT).show();
        }
    }
}
