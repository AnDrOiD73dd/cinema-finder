package com.ateam.zuml.cinemafinder.interactor.movie;

import com.ateam.zuml.cinemafinder.model.MovieModel;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;
import com.ateam.zuml.cinemafinder.repository.MoviesRepository;

import java.util.List;

import io.reactivex.Single;

public final class GetMoviesBySearchUseCase {

    private final MoviesRepository moviesRepository;

    public GetMoviesBySearchUseCase(final MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public Single<List<MovieModel>> execute(final String query, final int page, final Language language,
                                            final Region region) {
        return moviesRepository.getMoviesBySearch(query, page, language, region);
    }
}
