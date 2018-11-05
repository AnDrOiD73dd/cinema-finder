package com.ateam.zuml.cinemafinder.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ateam.zuml.cinemafinder.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<MovieModel> searchList;
    private OnItemClickListener itemClickListener;

    RecyclerViewAdapter(List<MovieModel> searchList) {
        this.searchList = searchList;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.search_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.poster.setImageResource(searchList.get(i).getPosterPath());
        viewHolder.title.setText(searchList.get(i).getTitle());
        viewHolder.originalTitle.setText(searchList.get(i).getOriginalTitle());
        viewHolder.releaseDate.setText(String.valueOf(searchList.get(i).getReleaseYear()));
        viewHolder.genres.setText(searchList.get(i).getGenres());
        viewHolder.voteAverage.setText(searchList.get(i).getVoteAverage());
    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

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
    }
}
