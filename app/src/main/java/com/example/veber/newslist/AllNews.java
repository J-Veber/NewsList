package com.example.veber.newslist;


import java.util.List;

public class AllNews {
    public String status;
    public String source;
    public String sortBy;
    public List<News> articles;


    @Override
    public String toString() {
        String returnStr = "";
        for (News news: articles) {
            returnStr += articles.toString() + "\n";
        }

        return returnStr;
    }
}
