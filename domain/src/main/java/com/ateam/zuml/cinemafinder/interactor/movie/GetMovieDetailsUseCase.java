package com.ateam.zuml.cinemafinder.interactor.movie;

import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.movie.MovieDetailsModel;
import com.ateam.zuml.cinemafinder.repository.MoviesRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public final class GetMovieDetailsUseCase {

    private final MoviesRepository moviesRepository;

    @Inject
    GetMovieDetailsUseCase(final MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public Single<MovieDetailsModel> execute(final String id, final Language language, final LogoSize logoSize) {
        return moviesRepository.getMovieById(id, language, logoSize);
    }
}
