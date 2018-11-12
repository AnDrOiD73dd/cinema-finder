package com.ateam.zuml.cinemafinder.mapper;

import com.ateam.zuml.cinemafinder.database.room.model.favorite.FavoriteEntity;
import com.ateam.zuml.cinemafinder.model.movie.BaseMovieModel;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class FavoritesMapperImpl implements FavoritesMapper {

    @Inject
    FavoritesMapperImpl() {
    }

    @Override
    public FavoriteEntity mapMovieListModel(final BaseMovieModel movieModel) {
        return new FavoriteEntity(movieModel.getId());
    }

    @Override
    public FavoriteEntity mapModelId(final String id) {
        return new FavoriteEntity(id);
    }
}
