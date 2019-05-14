package net.pt.demo.newsapp;

import net.pt.demo.newsapp.model.NewsArticle;

import java.util.ArrayList;
import java.util.List;

public class NewsStore {
    private static List<NewsArticle> newsArticles = new ArrayList<>();

    public static List<NewsArticle> getNewsArticles() {
        return newsArticles;
    }

    public static void setNewsArticles(List<NewsArticle> newsArticles) {
        NewsStore.newsArticles = newsArticles;
    }
}
