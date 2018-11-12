package com.ateam.zuml.cinemafinder.mapper;

import com.ateam.zuml.cinemafinder.database.room.model.favorite.FavoriteEntity;
import com.ateam.zuml.cinemafinder.model.movie.BaseMovieModel;

public interface FavoritesMapper {

    FavoriteEntity mapMovieListModel(final BaseMovieModel movieModel);
}
