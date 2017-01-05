package com.example.veber.newslist;
import android.util.Log;

import org.json.*;
import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Veiber on 05.01.2017.
 */

class NewsRestClientUsage {
    private static final String TAG = "debugLogs";
    public void getNews() throws JSONException {
        NewsRestClient.get("articles?source=the-next-web&sortBy=latest&apiKey=6a1989a70e56422a850a3533874e30e1",
                null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                Log.d(TAG, "response is JSONObject");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                // Pull out the first event on the public timeline
//                String tweetText = firstEvent.getString("text");
//
//                // Do something with the response
//                System.out.println(tweetText);
                Log.d(TAG, "response is JSONArray");
            }
        });
    }
}
