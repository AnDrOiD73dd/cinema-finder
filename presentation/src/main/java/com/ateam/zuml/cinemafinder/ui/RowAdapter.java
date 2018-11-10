package com.ateam.zuml.cinemafinder.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.presentation.presenter.RowPresenter;
import com.ateam.zuml.cinemafinder.presentation.view.RowListView;
import com.ateam.zuml.cinemafinder.presentation.view.RowView;
import com.ateam.zuml.cinemafinder.util.image.ImageLoader;

public class RowAdapter extends RecyclerView.Adapter<RowAdapter.ViewHolder> implements RowListView {

    private ImageLoader<ImageView> imageLoader;
    private RowPresenter.RowListPresenter presenter;

    public RowAdapter(RowPresenter.RowListPresenter presenter, ImageLoader<ImageView> imageLoader) {
        this.presenter = presenter;
        this.imageLoader = imageLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_card_item, viewGroup, false));

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

    class ViewHolder extends RecyclerView.ViewHolder implements RowView {

        @BindView(R.id.iv_poster_search) ImageView posterView;
        @BindView(R.id.tv_title_search) TextView titleView;
        @BindView(R.id.tv_vote_average_search) TextView voteAverageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> onClickRowItem());
        }

        @Override
        public void setPoster(String posterPath) {
            imageLoader.loadInto(posterPath, posterView);
        }

        @Override
        public void setPosterPlaceholder() {
            imageLoader.loadInto("-", posterView);
        }

        @Override
        public void setTitle(String title) {
            this.titleView.setText(title);
        }

        @Override
        public void setVoteAverage(String voteAverage) {
            this.voteAverageView.setText(voteAverage);
        }

        public void onClickRowItem() {
            presenter.showDetailsInfo(getAdapterPosition());
        }
    }
}
