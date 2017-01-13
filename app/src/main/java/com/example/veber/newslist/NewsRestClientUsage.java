package com.example.veber.newslist;
import android.util.Log;

import org.json.*;
import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;

class NewsRestClientUsage {
    private static final String TAG = "debugLogs";

    public void getNews() throws JSONException {

        NewsRestClient.get("?source=the-next-web&sortBy=latest&apiKey=6a1989a70e56422a850a3533874e30e1",
                null, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                Log.d(TAG, response.toString());
                Log.d(TAG, "response is JSONObject");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
            // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                Log.i("Fail", "AAAAAAAAAAAAAAAAAAAAAAAAAAaaa");
            }
        });
    }
}
