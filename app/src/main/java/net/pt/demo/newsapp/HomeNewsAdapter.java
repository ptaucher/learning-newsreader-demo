package net.pt.demo.newsapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.analytics.FirebaseAnalytics;

import net.pt.demo.newsapp.model.Article;
import net.pt.demo.newsapp.util.DateUtils;

import java.util.List;

public class HomeNewsAdapter extends RecyclerView.Adapter<HomeNewsAdapter.HomeNewsViewHolder> {
    List<Article> newsArticles;

    public HomeNewsAdapter(List<Article> newsArticles) {
        this.newsArticles = newsArticles;
    }

    @NonNull
    @Override
    public HomeNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_home, parent, false);
        HomeNewsViewHolder result = new HomeNewsViewHolder(view);
        return result;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeNewsViewHolder holder, final int position) {
        Article newsArticle = newsArticles.get(position);
        Glide.with(holder.getCardNewsImage().getContext())
                .load(newsArticle.getUrlToImage())
                .centerCrop()
                .into(holder.getCardNewsImage());
        Log.i(getClass().getSimpleName(), "imageView: " + newsArticle.getUrlToImage());
        holder.getCardNewsTitle().setText(newsArticle.getTitle());
        holder.getCardNewsTime().setText(DateUtils.formatNewsApiDate(newsArticle.getPublishedAt()));
        holder.getCardNewsContent().setText(newsArticle.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAnalytics analytics = FirebaseAnalytics.getInstance(v.getContext());
                Bundle bundle = new Bundle();
                bundle.putString("index", String.valueOf(position));
                analytics.logEvent("cardClicked", bundle);
                NewsDetailsActivity.launch(v.getContext(), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsArticles != null ? newsArticles.size() : 0;
    }

    public static class HomeNewsViewHolder extends RecyclerView.ViewHolder {
        ImageView cardNewsImage;
        TextView cardNewsTitle;
        TextView cardNewsTime;
        TextView cardNewsContent;

        public HomeNewsViewHolder(View itemView) {
            super(itemView);
            cardNewsImage = (ImageView) itemView.findViewById(R.id.card_news_image);
            cardNewsTitle = (TextView) itemView.findViewById(R.id.card_news_title);
            cardNewsTime = (TextView) itemView.findViewById(R.id.card_news_time);
            cardNewsContent = (TextView) itemView.findViewById(R.id.card_news_content);
        }

        public ImageView getCardNewsImage() {
            return cardNewsImage;
        }

        public TextView getCardNewsTitle() {
            return cardNewsTitle;
        }

        public TextView getCardNewsTime() {
            return cardNewsTime;
        }

        public TextView getCardNewsContent() {
            return cardNewsContent;
        }
    }
}
