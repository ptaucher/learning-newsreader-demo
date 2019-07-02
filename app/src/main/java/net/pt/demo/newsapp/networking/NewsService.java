package net.pt.demo.newsapp.networking;

import net.pt.demo.newsapp.model.GetArticlesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {
    @GET("articles?apiKey=" + NewsApi.API_KEY)
    Call<GetArticlesResponse> getArticles(
            @Query("source")
            String source,
            @Query("sortBy")
            String sortBy);
}
