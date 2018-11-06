package com.ateam.zuml.cinemafinder.interactor.movie;

import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;
import com.ateam.zuml.cinemafinder.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public final class GetMoviesBySearchUseCase {

    private final MoviesRepository moviesRepository;

    @Inject
    GetMoviesBySearchUseCase(final MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public Single<List<MovieListModel>> execute(final String query, final String page, final Language language,
                                                final Region region, final LogoSize logoSize) {
        return moviesRepository.getMoviesBySearch(query, page, language, region, logoSize);
    }
}
