package com.ateam.zuml.cinemafinder.ui.screens.main.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.ui.common.CollectionRowListView;
import com.ateam.zuml.cinemafinder.util.ImageLoader;

public class NowPlayingRowAdapter extends RecyclerView.Adapter<NowPlayingRowAdapter.ViewHolder>
        implements CollectionRowListView {

    private ImageLoader imageLoader;
    private HomePresenter.NowPlayingRowListPresenter presenter;

    NowPlayingRowAdapter(HomePresenter.NowPlayingRowListPresenter presenter, ImageLoader imageLoader) {
        this.presenter = presenter;
        this.imageLoader = imageLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.now_playing_row_item, viewGroup, false));
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

    class ViewHolder extends RecyclerView.ViewHolder implements NowPlayingRowCardView {

        @BindView(R.id.iv_poster_now_playing_list) ImageView posterView;
        @BindView(R.id.tv_title_now_playing_list) TextView titleView;
        @BindView(R.id.tv_release_date_now_playing_list) TextView releaseDateView;
        @BindView(R.id.tv_vote_average_now_playing_list) TextView voteAverageView;
        @BindView(R.id.tb_favorites_now_playing_list) ToggleButton toggleFavorites;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> onClickRowItem());
            toggleFavorites.setOnClickListener(v -> onFavoritesClick());
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
            toggleFavorites.setChecked(isFavorite);
        }

        void onClickRowItem() {
            presenter.onClickedRowItem(getAdapterPosition());
        }

        void onFavoritesClick() {
            presenter.onFavoritesClicked(getAdapterPosition());

        }
    }
}