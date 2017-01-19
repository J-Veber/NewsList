package com.example.veber.newslist;


import android.content.Context;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

public class News extends SugarRecord{
    public String author;
    public String title;
    public String description;
    public String url;
    public String urlToImage;
    public String publishedAt;

    @Ignore
    private transient LinearLayout container;
    @Ignore
    private transient ImageButton imageButton_action_with_news;

    public News(String author, String title, String description, String url, String urlToImage, String publishedAt){
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
    }
    public News (){}

    public LinearLayout getView(LayoutInflater inflater, final Context context) {
        LinearLayout container = (LinearLayout)inflater.inflate(R.layout.test_one_news, null, false);

        TextView authorTV = (TextView) container.findViewById(R.id.textView_author);
        authorTV.setText(author);
        TextView titleTV = (TextView) container.findViewById(R.id.textView_NewsTitle);
        titleTV.setText(title);
        TextView descriptionTV = (TextView) container.findViewById(R.id.TextView_Description);
        String news_content = description + "\n" + "\n" + "More here: " + "\n" + url  + "\n";

        if (descriptionTV != null) {
            descriptionTV.setText(news_content);
            Linkify.addLinks(descriptionTV, Linkify.ALL);
        }

        TextView publishedAtTV = (TextView) container.findViewById(R.id.textView_date);
        publishedAtTV.setText(publishedAt);
        final ImageView newsImage = (ImageView) container.findViewById(R.id.imageView_NewsImage);

        Glide.with( context )
                .load(urlToImage)
                .error( R.drawable.cat )
                .into( newsImage );


        imageButton_action_with_news = (ImageButton)container.findViewById(R.id.imageButton_saveNews);

        return container;
    }

    @Override
    public String toString(){
        return author + " " + title + " " + description + " " + url;
    }

    public void setSaveListner(final Context context) {

        imageButton_action_with_news.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                News.this.save();
                Toast.makeText(context, "News has been saved", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setDeleteListner(final Context context){

        imageButton_action_with_news.setImageResource(android.R.drawable.ic_menu_delete);
        imageButton_action_with_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                News.this.delete();
                container.removeAllViews();
                Toast.makeText(context, "Delete news", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
