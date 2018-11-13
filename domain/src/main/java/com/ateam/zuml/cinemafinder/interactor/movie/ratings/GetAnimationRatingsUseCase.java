package com.ateam.zuml.cinemafinder.interactor.movie.ratings;

import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public final class GetAnimationRatingsUseCase {

    private final MoviesRepository moviesRepository;

    @Inject
    GetAnimationRatingsUseCase(final MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public Single<List<MovieListModel>> execute(final String page, final Language language,
                                                final Region region, final LogoSize logoSize) {
        return moviesRepository.getAnimationRatingMovies(page, language, region, logoSize);
    }
}
