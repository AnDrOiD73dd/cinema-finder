package com.ateam.zuml.cinemafinder.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.presentation.presenter.SearchResponsePresenter;
import com.ateam.zuml.cinemafinder.presentation.view.SearchRowView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {

    private SearchResponsePresenter.SearchListPresenter presenter;
    private OnItemClickListener itemClickListener;

    SearchResultAdapter(SearchResponsePresenter.SearchListPresenter presenter) {
        this.presenter = presenter;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public SearchResultAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.search_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        presenter.bindViewAt(viewHolder, i);
    }

    @Override
    public int getItemCount() {
        return presenter.getSearchCount();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements SearchRowView {

        @BindView(R.id.iv_poster_search) ImageView poster;
        @BindView(R.id.tv_title_search) TextView title;
        @BindView(R.id.tv_original_title_search) TextView originalTitle;
        @BindView(R.id.tv_release_date_search) TextView releaseDate;
        @BindView(R.id.tv_genres_search) TextView genres;
        @BindView(R.id.tv_vote_average_search) TextView voteAverage;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> itemClickListener.onItemClick(v, getAdapterPosition()));
        }

        @Override
        public void setPoster(int path) {
            this.poster.setImageResource(path);
        }

        @Override
        public void setTitle(String title) {
            this.title.setText(title);
        }

        @Override
        public void setOriginalTitle(String originalTitle) {
            this.originalTitle.setText(originalTitle);
        }

        @Override
        public void setReleaseDate(String releaseDate) {
            this.releaseDate.setText(releaseDate);
        }

        @Override
        public void setGenres(String genres) {
            this.genres.setText(genres);
        }

        @Override
        public void setVoteAverage(String voteAverage) {
            this.voteAverage.setText(voteAverage);
        }
    }
}
