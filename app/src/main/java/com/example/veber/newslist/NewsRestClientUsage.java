package com.example.veber.newslist;
import android.util.Log;
import android.view.View;

import org.json.*;
import com.loopj.android.http.*;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;

import cz.msebera.android.httpclient.Header;

class NewsRestClientUsage {
    private static final String TAG = "NewsRestClient";
    private NewsListActivity receiver_activity;

    NewsRestClientUsage(NewsListActivity activity){
        receiver_activity = activity;
    }

    public void getNews() throws JSONException {

        NewsRestClient.get("?source=the-next-web&sortBy=latest&apiKey=6a1989a70e56422a850a3533874e30e1",
                null, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                Moshi moshi = new Moshi.Builder().build();
                JsonAdapter<AllNews> jsonAdapter = moshi.adapter(AllNews.class);

                try {
                    AllNews allNews = jsonAdapter.fromJson(response.toString());
                    for (News news: allNews.articles) {
                        View newsView = news.getView(receiver_activity.getLayoutInflater(), receiver_activity.getApplicationContext());
                        news.setSaveListner(receiver_activity.getApplicationContext());
                        receiver_activity.showOneNews(newsView);
                    }
                } catch (IOException ignored) {}
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
            // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                Log.i("Fail", "Cannot load data");
            }
        });
    }
}
