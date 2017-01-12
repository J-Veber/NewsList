package com.example.veber.newslist;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONException;

import cz.msebera.android.httpclient.Header;


public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton _menuIB;
        TextView _authorTV;
        TextView _dateTV;
        TextView _titleTV;
        ImageView _newspicIV;

        _menuIB = (ImageButton)findViewById(R.id.imageButton);
        _authorTV = (TextView)findViewById(R.id.textView_author);
        _dateTV = (TextView)findViewById(R.id.textView_date);
        _titleTV = (TextView)findViewById(R.id.textView_NewsTitle);
        _newspicIV = (ImageView)findViewById(R.id.imageView_NewsImage);

        NewsRestClientUsage _newsRestClientUsage = new NewsRestClientUsage();
        try {
            _newsRestClientUsage.getNews();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String json = "";
        //AllNews _allnews = new AllNews();
        Gson gson = new Gson();
        AllNews _allnews = gson.fromJson(json, AllNews.class);

        ImageLoader _imageLoader = ImageLoader.getInstance();
        //_imageLoader.displayImage();

    }
}
