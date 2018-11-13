package com.ateam.zuml.cinemafinder.ui.screens.main.ratings;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.ui.common.collection_row.CollectionRowCardView;
import com.ateam.zuml.cinemafinder.ui.common.collection_row.CollectionRowListView;
import com.ateam.zuml.cinemafinder.util.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RatingsCollectionRowAdapter extends RecyclerView.Adapter<RatingsCollectionRowAdapter.ViewHolder>
        implements CollectionRowListView {

    private ImageLoader imageLoader;
    private RatingsPresenter.RatingsRowListPresenter presenter;

    RatingsCollectionRowAdapter(RatingsPresenter.RatingsRowListPresenter presenter, ImageLoader imageLoader) {
        this.presenter = presenter;
        this.imageLoader = imageLoader;
    }

    @NonNull
    @Override
    public RatingsCollectionRowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RatingsCollectionRowAdapter.ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.collection_row_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RatingsCollectionRowAdapter.ViewHolder viewHolder, int i) {
        presenter.bindViewAt(viewHolder, i);
    }

    @Override
    public int getItemCount() {
        return presenter.getCollectionItems();
    }

    @Override
    public void refreshView() {
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements CollectionRowCardView {

        @BindView(R.id.iv_card_poster) ImageView posterView;
        @BindView(R.id.tv_card_title) TextView titleView;
        @BindView(R.id.tv_release_date_home_list) TextView releaseDateView;
        @BindView(R.id.tv_vote_average_home_list) TextView voteAverageView;
        @BindView(R.id.tb_card_favorites) ToggleButton toggleFavorites;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> onClickRowItem());
            toggleFavorites.setOnCheckedChangeListener((buttonView, isChecked) -> onFavoritesClick(isChecked));
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
        public void setReleaseDate(String releaseDate) {
            this.releaseDateView.setText(releaseDate);
        }

        @Override
        public void setVoteAverage(String voteAverage) {
            this.voteAverageView.setText(voteAverage);
        }

        @Override
        public void setToggleFavorites(boolean isFavorite) {
            if (isFavorite) {
                toggleFavorites.setChecked(true);
            } else {
                toggleFavorites.setChecked(false);
            }
        }

        void onClickRowItem() {
            presenter.onClickedRowItem(getAdapterPosition());
        }

        void onFavoritesClick(boolean isChecked) {
            presenter.onFavoritesClicked(isChecked, getAdapterPosition());
        }
    }
}