package com.ateam.zuml.cinemafinder.movies;

import com.ateam.zuml.cinemafinder.model.MovieModel;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;
import com.ateam.zuml.cinemafinder.repository.MoviesRepository;
import com.ateam.zuml.cinemafinder.service.api.ApiService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public final class MoviesRepositoryImpl implements MoviesRepository {

    private final ApiService apiService;

    @Inject
    MoviesRepositoryImpl(final ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Single<List<MovieModel>> getMoviesBySearch(final String query, final int page,
                                                                final Language language, final Region region) {
        return null;
    }

    @Override
    public Single<List<MovieModel>> getPopularMovies(int page, Language language, Region region) {
        return null;
    }
}
