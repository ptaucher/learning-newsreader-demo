package net.pt.demo.newsapp.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsApi {
    public static final String API_KEY = "bdd30416c4fc4bf7a9f4402f36987baa";
    public static final String API_BASE_PATH = "https://newsapi.org/v1/";

    private static final NewsService newsService = new Retrofit.Builder()
            .baseUrl(API_BASE_PATH)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsService.class);

    public static NewsService getNewsService() {
        return newsService;
    }
}
