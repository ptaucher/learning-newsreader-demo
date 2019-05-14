package net.pt.demo.newsapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import net.pt.demo.newsapp.model.NewsArticle;

public class NewsDetailsActivity extends AppCompatActivity {
    public static final String KEY_INDEX = "news_article_index";
    WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webView = (WebView) findViewById(R.id.activity_news_details_webview);
        progressBar = (ProgressBar) findViewById(R.id.activity_news_details_progressbar);

        int index = getIntent().getIntExtra(KEY_INDEX, -1);
        if (index != -1) {
            updateNewsDetails(index);
        } else {
            Toast.makeText(NewsDetailsActivity.this, "Incorrect news index passed", Toast.LENGTH_LONG).show();
        }
    }

    public void updateNewsDetails(int index) {
        NewsArticle newsArticle = NewsStore.getNewsArticles().get(index);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(NewsDetailsActivity.this, "Error in loading web page", Toast.LENGTH_LONG).show();
            }
        });
        webView.loadUrl(newsArticle.getUrlToArticle());
        getSupportActionBar().setTitle(newsArticle.getTitle());
    }

    public static void launch(Context context, int index) {
        Intent intent = new Intent(context, NewsDetailsActivity.class);
        intent.putExtra(KEY_INDEX, index);
        context.startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
