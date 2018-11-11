package com.ateam.zuml.cinemafinder.ui.screens.search;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.util.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder>
        implements SearchListView {

    private ImageLoader imageLoader;
    private SearchResponsePresenter.SearchListPresenter presenter;
    private OnItemClickListener itemClickListener;

    SearchResultAdapter(SearchResponsePresenter.SearchListPresenter presenter, ImageLoader imageLoader) {
        this.presenter = presenter;
        this.imageLoader = imageLoader;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
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

    // #################################### SearchListView #######################################

    @Override
    public void refreshView() {
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements SearchRowView {

        @BindView(R.id.iv_poster_search) ImageView posterView;
        @BindView(R.id.tv_title_search) TextView titleView;
        @BindView(R.id.tv_original_title_search) TextView originalTitleView;
        @BindView(R.id.tv_release_date_search) TextView releaseDateView;
        @BindView(R.id.tv_genres_search) TextView genresView;
        @BindView(R.id.tv_vote_average_search) TextView voteAverageView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> itemClickListener.onItemClick(getAdapterPosition()));
        }

        @Override
        public void setPoster(String posterPath) {
            imageLoader.loadInto(posterPath, posterView);
        }

        @Override
        public void setTitle(String title) {
            this.titleView.setText(title);
        }

        @Override
        public void setOriginalTitle(String originalTitle) {
            this.originalTitleView.setText(originalTitle);
        }

        @Override
        public void setReleaseDate(String releaseDate) {
            this.releaseDateView.setText(releaseDate);
        }

        @Override
        public void setGenres(String genres) {
            this.genresView.setText(genres);
        }

        @Override
        public void setVoteAverage(String voteAverage) {
            this.voteAverageView.setText(voteAverage);
        }
    }
}
