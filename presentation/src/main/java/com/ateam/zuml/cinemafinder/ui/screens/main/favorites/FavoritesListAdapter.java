package com.ateam.zuml.cinemafinder.ui.screens.main.favorites;

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

public class FavoritesListAdapter extends RecyclerView.Adapter<FavoritesListAdapter.ViewHolder>
        implements FavoriteListView {

    private ImageLoader imageLoader;
    private FavoritesPresenter.FavoritesListPresenter presenter;
    private OnItemClickListener itemClickListener;

    FavoritesListAdapter(FavoritesPresenter.FavoritesListPresenter presenter, ImageLoader imageLoader) {
        this.presenter = presenter;
        this.imageLoader = imageLoader;
    }

    public interface OnItemClickListener {

        void onItemClick(int position);

        void onRemoveItemClick(int position);
    }

    void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public FavoritesListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new FavoritesListAdapter.ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.favorite_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesListAdapter.ViewHolder viewHolder, int i) {
        presenter.bindViewAt(viewHolder, i);
    }

    @Override
    public int getItemCount() {
        return presenter.getItemsCount();
    }

    // #################################### FavoriteListView #######################################

    @Override
    public void refreshView() {
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements FavoriteRowView {

        @BindView(R.id.iv_poster_search) ImageView posterView;
        @BindView(R.id.tv_title_search) TextView titleView;
        @BindView(R.id.tv_original_title_search) TextView originalTitleView;
        @BindView(R.id.tv_release_date_search) TextView releaseDateView;
        @BindView(R.id.tv_genres_search) TextView genresView;
        @BindView(R.id.tv_vote_average_search) TextView voteAverageView;
        @BindView(R.id.iv_remove_favorite) ImageView removeView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> itemClickListener.onItemClick(getAdapterPosition()));
            removeView.setOnClickListener(v -> itemClickListener.onRemoveItemClick(getAdapterPosition()));
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