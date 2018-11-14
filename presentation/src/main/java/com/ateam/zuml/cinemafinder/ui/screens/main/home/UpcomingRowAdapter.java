package com.ateam.zuml.cinemafinder.ui.screens.main.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.ui.common.CollectionRowListView;
import com.ateam.zuml.cinemafinder.util.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UpcomingRowAdapter extends RecyclerView.Adapter<UpcomingRowAdapter.ViewHolder>
        implements CollectionRowListView {

    private ImageLoader imageLoader;
    private HomePresenter.UpcomingRowListPresenter presenter;

    UpcomingRowAdapter(HomePresenter.UpcomingRowListPresenter presenter, ImageLoader imageLoader) {
        this.presenter = presenter;
        this.imageLoader = imageLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.upcoming_row_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
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

    class ViewHolder extends RecyclerView.ViewHolder implements UpcomingRowCardView {

        @BindView(R.id.iv_poster_upcoming_list) ImageView posterView;
        @BindView(R.id.tv_title_upcoming_list) TextView titleView;
        @BindView(R.id.tv_release_date_upcoming_list) TextView releaseDateView;
        @BindView(R.id.tb_favorites_upcoming_list) ToggleButton toggleFavorites;

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