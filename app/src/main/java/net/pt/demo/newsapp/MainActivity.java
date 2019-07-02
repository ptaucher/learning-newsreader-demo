package net.pt.demo.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import net.pt.demo.newsapp.model.GetArticlesResponse;
import net.pt.demo.newsapp.networking.NewsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView newsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsRecyclerView = (RecyclerView) findViewById(R.id.activity_main_recyclerview);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Call<GetArticlesResponse> call = NewsApi.getNewsService().getArticles("polygon", "top");
        call.enqueue(new Callback<GetArticlesResponse>() {
            @Override
            public void onResponse(Call<GetArticlesResponse> call, Response<GetArticlesResponse> response) {
                GetArticlesResponse articlesResponse = response.body();
                NewsStore.setNewsArticles(articlesResponse.getArticles());
                HomeNewsAdapter homeNewsAdapter = new HomeNewsAdapter(NewsStore.getNewsArticles());
                newsRecyclerView.setAdapter(homeNewsAdapter);
            }

            @Override
            public void onFailure(Call<GetArticlesResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        "Received error: " + t,
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}
