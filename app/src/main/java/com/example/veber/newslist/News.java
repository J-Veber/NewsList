package com.example.veber.newslist;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class News {
    public String author;
    public String title;
    public String description;
    public String url;
    public String urlToImage;
    public String publishedAt;

    News(String author, String title, String description, String url, String urlToImage, String publishedAt){
        this.author = author;
    }

    LinearLayout getView(LayoutInflater inflater) {
        LinearLayout container = (LinearLayout)inflater.inflate(R.layout.one_news, null, false);
        ViewGroup.LayoutParams container_params = container.getLayoutParams();
        TextView title = (TextView) container.findViewById(R.id.textView_author);
        title.setText(author);
        return container;
    }
}
