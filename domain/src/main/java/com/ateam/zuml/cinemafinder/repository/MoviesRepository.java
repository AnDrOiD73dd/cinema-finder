package com.ateam.zuml.cinemafinder.repository;

import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;
import com.ateam.zuml.cinemafinder.model.movie.MovieDetailsModel;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import io.reactivex.Single;

import java.util.List;

public interface MoviesRepository {

    Single<List<MovieListModel>> getMoviesBySearch(final String query, final String page, final Language language,
                                                   final Region region, final LogoSize logoSize);

    Single<List<MovieListModel>> getPopularMovies(final String page, final Language language,
                                                  final Region region, final LogoSize logoSize);

    Single<MovieDetailsModel> getMovieById(final String id, final Language language, final LogoSize logoSize);

    Single<List<MovieListModel>> getNowPlayingMovies(final String page, final Language language,
                                                     final Region region, final LogoSize logoSize);

}
