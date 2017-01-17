package com.example.veber.newslist;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.orm.SugarRecord;

public class News extends SugarRecord{
    public String author;
    public String title;
    public String description;
    public String url;
    public String urlToImage;
    public String publishedAt;
    public Boolean flag;

    News(String author, String title, String description, String url, String urlToImage, String publishedAt){
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
    }
    News (){
        this.author = "";
        this.title = "";
        this.description = "";
        this.url = "";
        this.urlToImage = "";
        this.publishedAt = "";
    }

    public LinearLayout getView(LayoutInflater inflater, final Context context) {
        LinearLayout container = (LinearLayout)inflater.inflate(R.layout.test_one_news, null, false);
        //ViewGroup.LayoutParams container_params = container.getLayoutParams();

        TextView authorTV = (TextView) container.findViewById(R.id.textView_author);
        authorTV.setText(author);
        TextView titleTV = (TextView) container.findViewById(R.id.textView_NewsTitle);
        titleTV.setText(title);
        TextView descriptionTV = (TextView) container.findViewById(R.id.TextView_Description);
        descriptionTV.setText(description);
        TextView publishedAtTV = (TextView) container.findViewById(R.id.textView_date);
        publishedAtTV.setText(publishedAt);
        final ImageView newsImage = (ImageView) container.findViewById(R.id.imageView_NewsImage);
        //Glide.with(context).load(urlToImage).fitCenter().into(newsImage);
        //Glide.with(context).load(urlToImage).override(768,240).fitCenter().into(newsImage);


        Glide
                .with( context )
                .load(urlToImage)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        // todo log exception
                        newsImage.setImageResource(R.drawable.cat);
                        // important to return false so the error placeholder can be placed
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                } )
                .error( R.drawable.cat )
                .into( newsImage );


        final ImageButton imageButton_saveNews = (ImageButton)container.findViewById(R.id.imageButton_saveNews);

        imageButton_saveNews.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
//                News savedNews = new News(author,
//                        title,
//                        description,
//                        url,
//                        urlToImage,
//                        publishedAt);
//                savedNews.save();
                News.this.save();
                Toast.makeText(context, "Save news", Toast.LENGTH_LONG).show();
            }
        });
        return container;

    }

    @Override
    public String toString(){
        return author + " " + title + " " + description + " " + url;
    }
}
