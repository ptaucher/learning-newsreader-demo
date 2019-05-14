package net.pt.demo.newsapp.model;

public class NewsArticle {
    String title;
    String time;
    String details;
    String urlToArticle;
    String urlToImage;

    public NewsArticle(String title, String time, String details, String urlToArticle, String urlToImage) {
        this.title = title;
        this.time = time;
        this.details = details;
        this.urlToArticle = urlToArticle;
        this.urlToImage = urlToImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getUrlToArticle() {
        return urlToArticle;
    }

    public void setUrlToArticle(String urlToArticle) {
        this.urlToArticle = urlToArticle;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}
